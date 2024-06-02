package com.wiss.m426.service;

import com.wiss.m426.model.ScrumCoach;
import com.wiss.m426.repository.ScrumCoachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrumCoachesService {
    @Autowired
    private ScrumCoachesRepository scrumCoachesRepository;

    public List<ScrumCoach> getAllData() {
        return scrumCoachesRepository.findAll();
    }

    public ScrumCoach saveData(ScrumCoach sc) {
        return scrumCoachesRepository.save(sc);
    }
}
