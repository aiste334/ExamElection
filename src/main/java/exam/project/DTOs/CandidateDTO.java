package exam.project.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import exam.project.Entities.Candidate;
import exam.project.Entities.Party;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateDTO {
    Integer candidateId;
    String firstName;
    String lastName;
    Party party;
    Integer personalVotes;

    public CandidateDTO(Candidate candidate) {
        this.candidateId = candidate.getCandidateId();
        this.firstName = candidate.getFirstName();
        this.lastName = candidate.getLastName();
        this.party = candidate.getParty();
        this.personalVotes = candidate.getPersonalVotes();
    }
}