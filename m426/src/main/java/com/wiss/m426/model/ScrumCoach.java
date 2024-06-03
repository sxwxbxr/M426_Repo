package com.wiss.m426.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a Scrum Coach entity in the application.
 * This entity is mapped to a database table.
 */
@Entity
public class ScrumCoach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Represents the unique ID of the Scrum Coach
    private Long id;

    // Represents the name of the Scrum Coach
    private String name;

    // Represents the email of the Scrum Coach
    private String email;

    /**
     * Returns the ID of the Scrum Coach.
     * @return A Long representing the ID of the Scrum Coach.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the Scrum Coach.
     * @param id A Long containing the ID of the Scrum Coach.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the Scrum Coach.
     * @return A String representing the name of the Scrum Coach.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Scrum Coach.
     * @param name A String containing the name of the Scrum Coach.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the email of the Scrum Coach.
     * @return A String representing the email of the Scrum Coach.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the Scrum Coach.
     * @param email A String containing the email of the Scrum Coach.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}