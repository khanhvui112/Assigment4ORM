package fa.training.enity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author san vui
 * @create 19/10/2021 - 4:14 PM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "Interview")
public class InterView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_Id")
    private int interviewId;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "interviewer")
    private String interviewer;

    @Column(name = "comments", length = 2000)
    private String comments;

    @Column(name = "interview_Result")
    private String interviewResult;

    @Column(name = "remark", length = 1000)
    private String remark;

    @Column(name = "cadidate_Id")
    private int cadidate_Id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cadidate_Id", referencedColumnName = "candidate_Id", insertable = false, updatable = false)
    private Candidate candidate;

    public InterView() {
    }

    public InterView(String time, LocalDate date, String interviewer, String comments, String interviewResult, String remark, int cadidate_Id) {
        this.time = time;
        this.date = date;
        this.interviewer = interviewer;
        this.comments = comments;
        this.interviewResult = interviewResult;
        this.remark = remark;
        this.cadidate_Id = cadidate_Id;
    }

    public InterView(int interviewId, String time, LocalDate date, String interviewer, String comments, String interviewResult, String remark, int cadidate_Id) {
        this.interviewId = interviewId;
        this.time = time;
        this.date = date;
        this.interviewer = interviewer;
        this.comments = comments;
        this.interviewResult = interviewResult;
        this.remark = remark;
        this.cadidate_Id = cadidate_Id;
    }

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
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

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(String interviewResult) {
        this.interviewResult = interviewResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCadidate_Id() {
        return cadidate_Id;
    }

    public void setCadidate_Id(int cadidate_Id) {
        this.cadidate_Id = cadidate_Id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "InterView{" +
                "interviewId=" + interviewId +
                ", time='" + time + '\'' +
                ", date=" + date +
                ", interviewer='" + interviewer + '\'' +
                ", comments='" + comments + '\'' +
                ", interviewResult='" + interviewResult + '\'' +
                ", remark='" + remark + '\'' +
                ", cadidate_Id=" + cadidate_Id +
                ", candidate=" + candidate +
                '}';
    }
}
