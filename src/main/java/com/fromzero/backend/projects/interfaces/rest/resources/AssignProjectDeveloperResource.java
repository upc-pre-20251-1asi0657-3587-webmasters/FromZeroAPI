package com.fromzero.backend.projects.interfaces.rest.resources;


import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.user.domain.model.aggregates.Developer;

import java.util.List;

public record AssignProjectDeveloperResource(
        String name, String description, String state,
        Developer developer, List<Candidate> candidates) {

    public AssignProjectDeveloperResource{
        if(state==null){
            System.out.println("state is null");

            throw new NullPointerException("state is null");
        }
        if(name==null){
            System.out.println("name is null");
            throw new NullPointerException("name is null");
        }
        if(description==null){
            System.out.println("description is null");
            throw new NullPointerException("description is null");
        }
        if(candidates == null){
            System.out.println("there are no candidates to assign as developer");
            throw new NullPointerException("there are no candidates to assign as developer");
        }
    }
}
