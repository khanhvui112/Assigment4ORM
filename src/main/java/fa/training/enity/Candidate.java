package fa.training.enity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 4:02 PM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "Candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_Id")
    private int candidateId;

    @Column(name = "full_Name", nullable = false)
    private String fullName;

    @Column(name = "date_Of_Birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", columnDefinition = "int check(gender = 0 or gender = 1) ")
    private int gender;

    @Column(name = "graduation_year")
    private LocalDate graduationYear;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "skill")
    private String skill;

    @Column(name = "foreign_language")
    private String foreignLanguage;

    @Column(name = "level", columnDefinition = "int check(level >0 and level < 8)")
    private int level;

    @Column(name = "cv")
    private String cv;

    @Column(name = "allocation_status")
    private int allocationStatus;

    @Column(name = "remark", length = 1000)
    private String remark;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InterView> interViewList;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntryTest> entryTests;


    public Candidate(String fullName, LocalDate dateOfBirth, int gender, LocalDate graduationYear, String phone, String email, String skill, String foreignLanguage, int level, String cv, int allocationStatus, String remark) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.graduationYear = graduationYear;
        this.phone = phone;
        this.email = email;
        this.skill = skill;
        this.foreignLanguage = foreignLanguage;
        this.level = level;
        this.cv = cv;
        this.allocationStatus = allocationStatus;
        this.remark = remark;
    }

    public Candidate() {
    }

    public Candidate(String fullName, LocalDate dateOfBirth, int gender, LocalDate graduationYear, String phone, String email, String skill, String foreignLanguage, int level, String cv, int allocationStatus, String remark, List<InterView> interViewList, List<EntryTest> entryTests) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.graduationYear = graduationYear;
        this.phone = phone;
        this.email = email;
        this.skill = skill;
        this.foreignLanguage = foreignLanguage;
        this.level = level;
        this.cv = cv;
        this.allocationStatus = allocationStatus;
        this.remark = remark;
        this.interViewList = interViewList;
        this.entryTests = entryTests;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDate getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(LocalDate graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }

    public void setForeignLanguage(String foreignLanguage) {
        this.foreignLanguage = foreignLanguage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(int allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<InterView> getInterViewList() {
        return interViewList;
    }

    public void setInterViewList(List<InterView> interViewList) {
        this.interViewList = interViewList;
    }

    public List<EntryTest> getEntryTests() {
        return entryTests;
    }

    public void setEntryTests(List<EntryTest> entryTests) {
        this.entryTests = entryTests;
    }

    @Override
    public String toString() {
        return "candidateId=" + candidateId + "\t\t\t" +
                "fullName=" + fullName + "\t\t\t" + "\t\t\t" +
                "dateOfBirth=" + dateOfBirth + "\t\t\t" +
                "gender=" + gender + "\t\t\t" +
                "graduationYear=" + graduationYear + "\t\t\t" +
                "phone=" + phone + "\t\t\t" +
                "email=" + email + "\t\t\t" +
                "skill=" + skill + "\t\t\t" +
                "foreignLanguage=" + foreignLanguage + "\t\t\t" +
                "level=" + level + "\t\t\t" +
                "cv=" + cv + "\t\t\t" +
                "allocationStatus=" + allocationStatus + "\t\t\t" +
                "remark=" + remark + "\t\t\t" + "\n";
    }
}
