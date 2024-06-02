package com.wiss.m426.controller;

import com.wiss.m426.model.ScrumCoach;
import com.wiss.m426.service.ScrumCoachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ScrumCoaches")
public class ScrumCoachesController {
    @Autowired
    private ScrumCoachesService scrumCoachesService;

    @GetMapping
    public List<ScrumCoach> getAllData() {
        return scrumCoachesService.getAllData();
    }

    @PostMapping
    public ScrumCoach createData(@RequestBody ScrumCoach sc) {
        return scrumCoachesService.saveData(sc);
    }
}