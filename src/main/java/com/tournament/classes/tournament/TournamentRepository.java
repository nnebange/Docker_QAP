package com.golfclub.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;
import com.golfclub.member.Member;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByStartDateBetween(Date start, Date end);
    List<Tournament> findByLocation(String location);

    @Query("SELECT t.members FROM Tournament t WHERE t.id = :tournamentId")
    List<Member> findMembersByTournamentId(@Param("tournamentId") Long tournamentId);
}
