package com.fromzero.backend.projects.interfaces.rest.resources;


import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;

import java.util.List;

public record UpdateProjectCandidatesListResource(String name, String description, List<Candidate> candidates) {
    public UpdateProjectCandidatesListResource {
        if (name == null) {
            System.out.println("name is null");
            throw new NullPointerException("name is null");
        }
        if (description == null) {
            System.out.println("description is null");
            throw new NullPointerException("description is null");
        }
    }
}
