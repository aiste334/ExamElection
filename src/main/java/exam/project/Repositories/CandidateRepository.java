package exam.project.Repositories;

import exam.project.Entities.Candidate;
import exam.project.Entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    List<Candidate> findAll();
    List<Candidate> findCandidatesByParty(Party party);
    Candidate findCandidateByCandidateId(Integer candidateId);
}
