package com.golfclub.tournament;

import com.golfclub.member.Member;
import com.golfclub.member.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList; // ✅ Import added

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    public TournamentService(TournamentRepository tournamentRepository, MemberRepository memberRepository) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(Long id) {
        return tournamentRepository.findById(id).orElse(null);
    }

    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    public Tournament addMemberToTournament(Long tournamentId, Long memberId) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(tournamentId);
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        if (optionalTournament.isPresent() && optionalMember.isPresent()) {
            Tournament tournament = optionalTournament.get();
            Member member = optionalMember.get();

            // ✅ Fix: Ensure we don't overwrite members list
            if (tournament.getMembers() == null) {
                tournament.setMembers(new ArrayList<>());
            }

            if (!tournament.getMembers().contains(member)) {
                tournament.getMembers().add(member);
            }

            return tournamentRepository.save(tournament);
        }
        return null;
    }

    public List<Member> getMembersInTournament(Long tournamentId) {
        return tournamentRepository.findMembersByTournamentId(tournamentId);
    }
}
