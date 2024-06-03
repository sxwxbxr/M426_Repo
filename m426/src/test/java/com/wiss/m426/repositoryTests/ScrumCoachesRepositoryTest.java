package com.wiss.m426.repositoryTests;

import com.wiss.m426.model.ScrumCoach;
import com.wiss.m426.repository.ScrumCoachesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ScrumCoachesRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ScrumCoachesRepository scrumCoachesRepository;

    private ScrumCoach coach;

    @BeforeEach
    public void setUp() {
        coach = new ScrumCoach();
        coach.setName("John Doe");
        coach.setEmail("john.doe@example.com");
        entityManager.persistAndFlush(coach);
    }

    @Test
    public void findById_ShouldReturnScrumCoach() {
        Optional<ScrumCoach> foundCoach = scrumCoachesRepository.findById(coach.getId());
        assertThat(foundCoach).isPresent();
        assertThat(foundCoach.get().getName()).isEqualTo(coach.getName());
        assertThat(foundCoach.get().getEmail()).isEqualTo(coach.getEmail());
    }

    @Test
    public void findById_ShouldReturnEmptyOptional() {
        Optional<ScrumCoach> foundCoach = scrumCoachesRepository.findById(-1L);
        assertThat(foundCoach).isNotPresent();
    }
}