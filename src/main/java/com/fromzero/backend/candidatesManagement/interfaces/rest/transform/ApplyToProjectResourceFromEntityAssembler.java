package com.fromzero.backend.candidatesManagement.interfaces.rest.transform;

import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.candidatesManagement.interfaces.rest.resources.ApplyToProjectResource;
import com.fromzero.backend.projects.domain.model.aggregates.Project;

public class ApplyToProjectResourceFromEntityAssembler {

    public static ApplyToProjectResource toResourceFromEntity (Candidate entity) {
        return new ApplyToProjectResource(entity.getDeveloper().getId());
    }
}
