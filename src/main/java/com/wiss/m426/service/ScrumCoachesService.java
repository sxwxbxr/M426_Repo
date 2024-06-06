package com.wiss.m426.service;

import com.wiss.m426.model.ScrumCoach;
import com.wiss.m426.repository.ScrumCoachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling operations related to Scrum Coaches.
 * This class uses ScrumCoachesRepository for performing database operations.
 */
@Service
public class ScrumCoachesService {

    // Repository for performing database operations on ScrumCoach entities
    @Autowired
    private ScrumCoachesRepository scrumCoachesRepository;

    /**
     * Fetches all ScrumCoach entities from the database.
     * @return A List of ScrumCoach entities.
     */
    public List<ScrumCoach> getAllData() {
        return scrumCoachesRepository.findAll();
    }

    /**
     * Saves a ScrumCoach entity to the database.
     * @param sc The ScrumCoach entity to be saved.
     * @return The saved ScrumCoach entity.
     */
    public ScrumCoach saveData(ScrumCoach sc) {
        return scrumCoachesRepository.save(sc);
    }

    /**
     * Deletes a ScrumCoach entity from the database.
     * @param id The ID of the ScrumCoach entity to be deleted.
     */
    public void deleteData(Long id) {
        scrumCoachesRepository.deleteById(id);
    }
}