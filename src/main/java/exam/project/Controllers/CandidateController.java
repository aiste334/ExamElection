package exam.project.Controllers;


import com.fasterxml.jackson.databind.node.ObjectNode;
import exam.project.DTOs.CandidateDTO;
import exam.project.Entities.Candidate;
import exam.project.Services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class CandidateController {
    CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @GetMapping("/candidate/{id}")
    CandidateDTO getCandidateById(@PathVariable int id){
        return candidateService.getCandidateById(id);
    }

    @GetMapping("/candidates")
    List<CandidateDTO> getAllCandidates(){
        return candidateService.getAllCandidates();
    }

    @GetMapping("/candidates/{id}")
    List<CandidateDTO> getAllCandidatesByParty(@PathVariable int id){
        return candidateService.getAllCandidatesByParty(id);
    }
    @PostMapping("/candidate")
    CandidateDTO createNewCandidate(@RequestBody ObjectNode body){
        return candidateService.createCandidate(body.get("firstName").asText(), body.get("lastName").asText(),
                body.get("partyId").asInt(), body.get("personalVotes").asInt());
    }
    @DeleteMapping("/candidate/{id}")
    void removeCandidate(@PathVariable int id){
        candidateService.deleteCandidate(id);
    }
    @PatchMapping("/candidate/{id}")
    CandidateDTO updateParty(@RequestBody ObjectNode body, @PathVariable int id){
        return candidateService.updateCandidateParty(id, body.get("partyId").asInt());
    }
}
