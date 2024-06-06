package com.wiss.m426.controllerTests;

import com.wiss.m426.controller.ScrumCoachesController;
import com.wiss.m426.model.ScrumCoach;
import com.wiss.m426.service.ScrumCoachesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.mock.web.MockHttpServletRequest;


public class ScrumCoachesControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ScrumCoachesService scrumCoachesService;

    @InjectMocks
    private ScrumCoachesController scrumCoachesController;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(scrumCoachesController)
                .build();
    }

    @Test
    public void getAllData_ShouldReturnListOfScrumCoaches() throws Exception {
        ScrumCoach coach1 = new ScrumCoach();
        coach1.setId(1L);
        coach1.setName("John Doe");
        coach1.setEmail("john.doe@example.com");

        ScrumCoach coach2 = new ScrumCoach();
        coach2.setId(2L);
        coach2.setName("Jane Doe");
        coach2.setEmail("jane.doe@example.com");

        List<ScrumCoach> coaches = Arrays.asList(coach1, coach2);

        given(scrumCoachesService.getAllData()).willReturn(coaches);

        mockMvc.perform(get("/api/ScrumCoaches"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Jane Doe"))
                .andExpect(jsonPath("$[1].email").value("jane.doe@example.com"));
    }


    @Test
       public void createData_ShouldReturnCreatedScrumCoach() throws Exception {
        ScrumCoach coach = new ScrumCoach();
        coach.setId(1L);
        coach.setName("John Doe");
        coach.setEmail("john.doe@example.com");

        given(scrumCoachesService.saveData(any(ScrumCoach.class))).willReturn(coach);

        mockMvc.perform(post("/api/ScrumCoaches")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\", \"email\":\"john.doe@example.com\"}")
                        .with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteData_ShouldDeleteScrumCoach() throws Exception {
        mockMvc.perform(delete("/api/ScrumCoaches/1"))
                .andExpect(status().isOk());

        verify(scrumCoachesService, times(1)).deleteData(1L);
    }

    private static RequestPostProcessor csrf() {
        return new RequestPostProcessor() {
            @Override
            public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                request.setMethod("POST");
                return request;
            }
        };
    }
}