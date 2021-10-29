package fa.training.enity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author san vui
 * @create 19/10/2021 - 4:23 PM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "EntryTest")
public class EntryTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_Id")
    private int testId;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "language_Valuator")
    private String languageValuator;

    @Column(name = "language_Result", precision = 4, scale = 2, columnDefinition = "decimal(4,2) check(language_Result >=0 and language_Result < 11)")
    private double languageResult;

    @Column(name = "technical_Valuator")
    private String technicalValuator;

    @Column(name = "technical_Result", precision = 4, scale = 2, columnDefinition = "decimal(4,2) check(technical_Result >=0 and technical_Result < 11)")
    private double technicalResult;

    @Column(name = "result", columnDefinition = "varchar(255) check(result='fail' or result = 'pass' )")
    private String result;

    @Column(name = "remark", length = 1000)
    private String remark;

    @Column(name = "candidate_Id")
    private int candidate_Id;

    @Column(name = "entry_Test_Skill")
    private String entryTestSkill;

    @ManyToOne(optional = false)
    @JoinColumn(name = "candidate_Id", referencedColumnName = "candidate_Id", insertable = false, updatable = false)
    private Candidate candidate;

    public EntryTest() {
    }

    public EntryTest(int testId, String time, LocalDate date, String languageValuator, double languageResult, String technicalValuator, double technicalResult, String result, String remark, int candidate_Id, String entryTestSkill) {
        this.testId = testId;
        this.time = time;
        this.date = date;
        this.languageValuator = languageValuator;
        this.languageResult = languageResult;
        this.technicalValuator = technicalValuator;
        this.technicalResult = technicalResult;
        this.result = result;
        this.remark = remark;
        this.candidate_Id = candidate_Id;
        this.entryTestSkill = entryTestSkill;
    }

    public EntryTest(String time, LocalDate date, String languageValuator, double languageResult, String technicalValuator, double technicalResult, String result, String remark, String entryTestSkill, int candidate_Id) {
        this.time = time;
        this.date = date;
        this.languageValuator = languageValuator;
        this.languageResult = languageResult;
        this.technicalValuator = technicalValuator;
        this.technicalResult = technicalResult;
        this.result = result;
        this.remark = remark;
        this.entryTestSkill = entryTestSkill;
        this.candidate_Id = candidate_Id;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLanguageValuator() {
        return languageValuator;
    }

    public void setLanguageValuator(String languageValuator) {
        this.languageValuator = languageValuator;
    }

    public double getLanguageResult() {
        return languageResult;
    }

    public void setLanguageResult(double languageResult) {
        this.languageResult = languageResult;
    }

    public String getTechnicalValuator() {
        return technicalValuator;
    }

    public void setTechnicalValuator(String technicalValuator) {
        this.technicalValuator = technicalValuator;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public double getTechnicalResult() {
        return technicalResult;
    }

    public void setTechnicalResult(double technicalResult) {
        this.technicalResult = technicalResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEntryTestSkill() {
        return entryTestSkill;
    }

    public void setEntryTestSkill(String entryTestSkill) {
        this.entryTestSkill = entryTestSkill;
    }

    @Override
    public String toString() {
        return "EntryTest{" +
                "testId=" + testId +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", languageValuator='" + languageValuator + '\'' +
                ", languageResult=" + languageResult +
                ", technicalValuator=" + technicalValuator +
                ", technicalResult=" + technicalResult +
                ", result='" + result + '\'' +
                ", remark='" + remark + '\'' +
                ", entryTestSkill='" + entryTestSkill + '\'' +
                '}';
    }
}
