package com.fromzero.backend.projects.interfaces.rest.resources;

import com.fromzero.backend.projects.domain.valueobjects.ProjectTypeEnum;

import java.util.List;

public record CreateProjectResource(
        String name,
        String description,
        Long ownerId,
        List<Long> languages,
        List<Long> frameworks,
        ProjectTypeEnum type,
        String budget,
        String methodologies){
}
