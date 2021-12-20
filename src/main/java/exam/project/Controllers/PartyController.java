package exam.project.Controllers;


import exam.project.DTOs.PartyDTO;
import exam.project.Services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class PartyController {
    PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService){
        this.partyService = partyService;
    }

    //Gets all parties
    @GetMapping("/parties")
    List<PartyDTO> getAllParties(){
        return partyService.getAllParties();
    }
}
