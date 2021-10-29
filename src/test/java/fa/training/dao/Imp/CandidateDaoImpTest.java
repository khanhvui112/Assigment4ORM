package fa.training.dao.Imp;

import fa.training.enity.Candidate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author san vui
 * @create 20/10/2021 - 3:35 PM
 * @sanvankhanh@gmail.com
 */
class CandidateDaoImpTest {

   private  CandidateDaoImp candidateDaoImp= new CandidateDaoImp();

    @Test
   void findAllCandidateNullTest() {
        String skill = "Angul";
        int level = 2;
        assertNull(candidateDaoImp.findAllCandidate(skill,level));
    }
    @Test
    void findAllCandidateNotNullTest() {
        String skill = "Angular";
        int level = 2;
        assertNotNull( candidateDaoImp.findAllCandidate(skill,level));
    }

    @Test
    void findAllCandidateLanguageNullTest() {
        String language = "Japane";
        String skill = "Python/ML";
        assertNull(candidateDaoImp.findAllCandidateLanguage(language,skill));
    }

    @Test
    void findAllCandidateLanguageNotNullTest() {
        String language = "Japanese";
        String skill = "Python/ML";
        assertNotNull(candidateDaoImp.findAllCandidateLanguage(language,skill));
    }


    @Test
    void findAllCandidateSkillAndEntryNullTest() {
        String skill="Jav";
        String result = "pass";
        String dateStr = "01/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        assertNull(candidateDaoImp.findAllCandidateSkillAndEntry(skill,result,date));
    }

    @Test
    void findAllCandidateSkillAndEntryNotNullTest() {
        String skill="Java";
        String result = "pass";
        String dateStr = "01/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        assertNotNull(candidateDaoImp.findAllCandidateSkillAndEntry(skill,result,date));
    }

    @Test
    void findAllCandidatePassAndDateNotNullTest() {
        String result = "pass";
        String dateStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        assertNotNull(candidateDaoImp.findAllCandidatePassAndDate(result, date));
    }

    @Test
    void findAllCandidatePassAndDateNullTest() {
        String result = "fail";
        String dateStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        assertNull(candidateDaoImp.findAllCandidatePassAndDate(result, date));
    }

    @Test
    void insertCandidateTrue(){
        String dateOfBirthStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr,formatter);

        String graduationYearStr = "15/10/2020";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate graduationYear = LocalDate.parse(graduationYearStr,formatter);
        Candidate candidate = new Candidate("Nguyen Huu Da",dateOfBirth,1,graduationYear,"","","C++","VN",5,"",4,"Oke");
        assertTrue(candidateDaoImp.insertCandidate(candidate));
    }

    @Test
    void updateCandidateNullTest(){

    }
}