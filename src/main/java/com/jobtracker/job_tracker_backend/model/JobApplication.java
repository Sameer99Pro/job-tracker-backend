package com.jobtracker.job_tracker_backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String companyName;
    private String jobRole;
    private String location;
    private String status;
    private String jobPortal;
    private String notes;
    private String interviewDate;
    private String resumeLink;

    @Temporal(TemporalType.DATE)
    private Date appliedDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getJobRole() { return jobRole; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getJobPortal() { return jobPortal; }
    public void setJobPortal(String jobPortal) { this.jobPortal = jobPortal; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Date getAppliedDate() { return appliedDate; }
    public void setAppliedDate(Date appliedDate) { this.appliedDate = appliedDate; }

    public String getInterviewDate() { return interviewDate; }
    public void setInterviewDate(String interviewDate) { this.interviewDate = interviewDate; }

    public String getResumeLink() { return resumeLink; }
    public void setResumeLink(String resumeLink) { this.resumeLink = resumeLink; }
}