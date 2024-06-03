package com.wiss.m426.serviceTests;

import com.wiss.m426.model.ScrumCoach;
import com.wiss.m426.repository.ScrumCoachesRepository;
import com.wiss.m426.service.ScrumCoachesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ScrumCoachesServiceTest {

    @Mock
    private ScrumCoachesRepository scrumCoachesRepository;

    @InjectMocks
    private ScrumCoachesService scrumCoachesService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllData_ShouldReturnAllScrumCoaches() {
        ScrumCoach coach1 = new ScrumCoach();
        coach1.setName("John Doe");
        coach1.setEmail("john.doe@example.com");

        ScrumCoach coach2 = new ScrumCoach();
        coach2.setName("Jane Doe");
        coach2.setEmail("jane.doe@example.com");

        List<ScrumCoach> coaches = Arrays.asList(coach1, coach2);

        when(scrumCoachesRepository.findAll()).thenReturn(coaches);

        List<ScrumCoach> returnedCoaches = scrumCoachesService.getAllData();

        verify(scrumCoachesRepository, times(1)).findAll();
        assert(returnedCoaches.size() == 2);
    }

    @Test
    public void saveData_ShouldReturnSavedScrumCoach() {
        ScrumCoach coach = new ScrumCoach();
        coach.setName("John Doe");
        coach.setEmail("john.doe@example.com");

        when(scrumCoachesRepository.save(any(ScrumCoach.class))).thenReturn(coach);

        ScrumCoach returnedCoach = scrumCoachesService.saveData(coach);

        verify(scrumCoachesRepository, times(1)).save(coach);
        assert(returnedCoach.getName().equals(coach.getName()));
        assert(returnedCoach.getEmail().equals(coach.getEmail()));
    }

    @Test
    public void deleteData_ShouldCallDeleteById() {
        doNothing().when(scrumCoachesRepository).deleteById(anyLong());

        scrumCoachesService.deleteData(1L);

        verify(scrumCoachesRepository, times(1)).deleteById(1L);
    }
}