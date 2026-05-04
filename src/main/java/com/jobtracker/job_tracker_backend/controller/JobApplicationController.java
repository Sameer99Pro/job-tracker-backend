package com.jobtracker.job_tracker_backend.controller;

import com.jobtracker.job_tracker_backend.model.JobApplication;
import com.jobtracker.job_tracker_backend.service.JobApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174" , "https://job-tracker-frontend-zeta-wine.vercel.app"})
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    // GET ALL
    @GetMapping
    public List<JobApplication> getAllApplications() {
        return service.getAllApplications();
    }

    // GET BY USER ID
    @GetMapping("/user/{userId}")
    public List<JobApplication> getUserApplications(@PathVariable Long userId) {
        return service.getUserApplications(userId);
    }

    // ADD
    @PostMapping
    public JobApplication addApplication(@RequestBody JobApplication application) {
        return service.addApplication(application);
    }

    // UPDATE
    @PutMapping("/{id}")
    public JobApplication updateApplication(@PathVariable Long id,
                                            @RequestBody JobApplication application) {
        return service.updateApplication(id, application);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
    }


}