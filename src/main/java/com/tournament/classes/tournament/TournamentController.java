package com.golfclub.tournament;

import com.golfclub.member.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        Tournament tournament = tournamentService.getTournamentById(id);
        return tournament != null ? ResponseEntity.ok(tournament) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.saveTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{tournamentId}/addMember/{memberId}")
    public ResponseEntity<Tournament> addMemberToTournament(@PathVariable Long tournamentId, @PathVariable Long memberId) {
        Tournament updatedTournament = tournamentService.addMemberToTournament(tournamentId, memberId);
        return updatedTournament != null ? ResponseEntity.ok(updatedTournament) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{tournamentId}/members")
    public ResponseEntity<List<Member>> getMembersInTournament(@PathVariable Long tournamentId) {
        List<Member> members = tournamentService.getMembersInTournament(tournamentId);
        return !members.isEmpty() ? ResponseEntity.ok(members) : ResponseEntity.noContent().build();
    }
}
