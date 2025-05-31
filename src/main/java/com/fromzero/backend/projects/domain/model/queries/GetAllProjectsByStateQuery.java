package com.fromzero.backend.projects.domain.model.queries;

import com.fromzero.backend.projects.domain.valueobjects.ProjectStateEnum;

public record GetAllProjectsByStateQuery(ProjectStateEnum state) {
    public GetAllProjectsByStateQuery {
        if (state == null ) {
            throw new IllegalArgumentException("state cannot be null or empty");
        }
    }
}
