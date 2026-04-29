package com.jobtracker.job_tracker_backend.service;

import com.jobtracker.job_tracker_backend.model.JobApplication;
import com.jobtracker.job_tracker_backend.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    public List<JobApplication> getUserApplications(Long userId) {
        return repository.findByUserId(userId);
    }

    public JobApplication addApplication(JobApplication application) {
        return repository.save(application);
    }

    public JobApplication updateApplication(Long id, JobApplication updated) {
        JobApplication existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found: " + id));

        existing.setCompanyName(updated.getCompanyName());
        existing.setJobRole(updated.getJobRole());
        existing.setLocation(updated.getLocation());
        existing.setStatus(updated.getStatus());
        existing.setJobPortal(updated.getJobPortal());
        existing.setNotes(updated.getNotes());
        existing.setAppliedDate(updated.getAppliedDate());
        existing.setInterviewDate(updated.getInterviewDate());
        existing.setResumeLink(updated.getResumeLink());

        return repository.save(existing);
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }
}