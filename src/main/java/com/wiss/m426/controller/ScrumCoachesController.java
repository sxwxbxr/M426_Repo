package com.wiss.m426.controller;

import com.wiss.m426.model.ScrumCoach;
import com.wiss.m426.service.ScrumCoachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling HTTP requests related to Scrum Coaches.
 * This class uses ScrumCoachesService for performing operations on ScrumCoach entities.
 */
@RestController
@RequestMapping("/api/ScrumCoaches")
public class ScrumCoachesController {

    // Service for performing operations on ScrumCoach entities
    @Autowired
    private ScrumCoachesService scrumCoachesService;

    /**
     * Handles GET requests to fetch all ScrumCoach entities.
     * @return A List of ScrumCoach entities.
     */
    @GetMapping
    public List<ScrumCoach> getAllData() {
        return scrumCoachesService.getAllData();
    }

    /**
     * Handles POST requests to create a new ScrumCoach entity.
     * @param sc The ScrumCoach entity to be created.
     * @return The created ScrumCoach entity.
     */
    @PostMapping
    public ScrumCoach createData(@RequestBody ScrumCoach sc) {
        return scrumCoachesService.saveData(sc);
    }

    /**
     * Handles DELETE requests to delete a ScrumCoach entity.
     * @param id The ID of the ScrumCoach entity to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable Long id) {
        scrumCoachesService.deleteData(id);
    }
}