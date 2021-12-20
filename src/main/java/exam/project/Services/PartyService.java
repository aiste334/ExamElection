package exam.project.Services;

import exam.project.DTOs.PartyDTO;
import exam.project.Entities.Party;
import exam.project.Repositories.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyService {
    private final PartyRepository partyRepository;


    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public List<PartyDTO> getAllParties() {
        List<Party> partyList = partyRepository.findAll();
        List<PartyDTO> partyDTOList = new ArrayList<>();
        for (Party party : partyList) {
            partyDTOList.add(new PartyDTO(party));
        }
        return partyDTOList;
    }
}
