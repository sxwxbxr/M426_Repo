package com.wiss.m426.modelTests;

import com.wiss.m426.model.ScrumCoach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ScrumCoachTest {

    private ScrumCoach scrumCoach;

    @BeforeEach
    public void setUp() {
        scrumCoach = new ScrumCoach();
    }

    @Test
    public void setIdAndGetId_ShouldReturnCorrectId() {
        scrumCoach.setId(1L);
        assertEquals(1L, scrumCoach.getId());
    }

    @Test
    public void setNameAndGetName_ShouldReturnCorrectName() {
        scrumCoach.setName("John Doe");
        assertEquals("John Doe", scrumCoach.getName());
    }

    @Test
    public void setEmailAndGetEmail_ShouldReturnCorrectEmail() {
        scrumCoach.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", scrumCoach.getEmail());
    }

    @Test
    public void setNameWithNull_ShouldReturnNull() {
        scrumCoach.setName(null);
        assertNull(scrumCoach.getName());
    }

    @Test
    public void setEmailWithNull_ShouldReturnNull() {
        scrumCoach.setEmail(null);
        assertNull(scrumCoach.getEmail());
    }
}