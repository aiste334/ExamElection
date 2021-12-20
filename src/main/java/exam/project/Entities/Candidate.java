package exam.project.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "candidate", schema = "examelection")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id", nullable = false, length = 10)
    private int candidateId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;
    @Basic
    @Column(name = "personal_votes", nullable = false, length = 20)
    private int personalVotes;

    public Candidate(String firstName, String lastName, Party party, int personalVotes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
        this.personalVotes = personalVotes;
    }
}
