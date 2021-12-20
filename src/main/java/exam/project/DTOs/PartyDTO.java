package exam.project.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import exam.project.Entities.Party;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyDTO {
    Integer partyId;
    String partyName;
    Integer partyVotes;

    public PartyDTO(Party party) {
        this.partyId = party.getPartyId();
        this.partyName = party.getPartyName();
        this.partyVotes = party.getPartyVotes();
    }
}
