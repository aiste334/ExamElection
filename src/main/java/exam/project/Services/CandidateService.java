package exam.project.Services;

import exam.project.DTOs.CandidateDTO;
import exam.project.Entities.Candidate;
import exam.project.Entities.Party;
import exam.project.Repositories.CandidateRepository;
import exam.project.Repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final PartyRepository partyRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }

    public CandidateDTO getCandidateById(int id){ return new CandidateDTO(candidateRepository.findCandidateByCandidateId(id)); }

    public List<CandidateDTO> getAllCandidates() {
        List<Candidate> candidateList = candidateRepository.findAll();
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        for (Candidate candidate : candidateList) {
            candidateDTOList.add(new CandidateDTO(candidate));
        }
        return candidateDTOList;
    }
    public List<CandidateDTO> getAllCandidatesByParty(Integer partyId) {
        Party party = partyRepository.findPartyByPartyId(partyId);
        List<Candidate> candidateList = candidateRepository.findCandidatesByParty(party);
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        for (Candidate candidate : candidateList) {
            candidateDTOList.add(new CandidateDTO(candidate));
        }
        return candidateDTOList;
    }
    public CandidateDTO createCandidate(String firstName, String lastName, int partyId, int personalVotes){
        Party party = partyRepository.findPartyByPartyId(partyId);
        Candidate candidate = candidateRepository.save(new Candidate(firstName, lastName, party, personalVotes));
        return new CandidateDTO(candidate);
    }

    public void deleteCandidate(Integer candidateId) {
        candidateRepository.deleteById(candidateId);
    }

    public CandidateDTO updateCandidateParty(int candidateId, int partyId){
        try {
            Party party = partyRepository.findPartyByPartyId(partyId);
            Candidate candidate = candidateRepository.findCandidateByCandidateId(candidateId);
            candidate.setParty(party);
            return new CandidateDTO(candidateRepository.save(candidate));
        }catch (Exception ex){
            System.out.println("Failed");
        }
        return null;
    }
}
