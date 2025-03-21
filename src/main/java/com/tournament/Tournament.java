package com.golfclub.tournament;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.golfclub.member.Member;

@Entity
@Table(name = "tournament")  
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate; 

    @Column(name = "end_date")
    private LocalDate endDate; 

    private String location;
    private double entryFee;
    private double cashPrize;

    @ManyToMany(mappedBy = "tournaments", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getEntryFee() { return entryFee; }
    public void setEntryFee(double entryFee) { this.entryFee = entryFee; }

    public double getCashPrize() { return cashPrize; }
    public void setCashPrize(double cashPrize) { this.cashPrize = cashPrize; }

    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", entryFee=" + entryFee +
                ", cashPrize=" + cashPrize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament tournament = (Tournament) o;
        return id != null && id.equals(tournament.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
