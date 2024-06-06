package com.wiss.m426.repository;

import com.wiss.m426.model.ScrumCoach;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on ScrumCoach entities.
 * This interface extends JpaRepository which provides JPA related methods 
 * such as save(), findById(), findAll(), etc.
 */
public interface ScrumCoachesRepository extends JpaRepository<ScrumCoach, Long> {
}