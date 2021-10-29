package fa.training.dao;

import fa.training.enity.Candidate;

import java.time.LocalDate;
import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 5:28 PM
 * @sanvankhanh@gmail.com
 */
public interface CandidateDao {
    List<Candidate> findAllCandidate(String skill, int level);

    List<Candidate> findAllCandidateLanguage(String foreign_language, String skill);

    List<Candidate> findAllCandidateSkillAndEntry(String skill, String result, LocalDate date);

    List<Candidate> findAllCandidatePassAndDate(String result, LocalDate date);

    List<Candidate> updateCandidateNull();

    boolean insertCandidate(Candidate candidate);

}
