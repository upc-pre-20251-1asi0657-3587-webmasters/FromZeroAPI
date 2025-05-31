package com.fromzero.backend.candidatesManagement.interfaces.rest.transform;

import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.candidatesManagement.interfaces.rest.resources.CandidateResource;

public class CandidateResourceFromEntityAssembler {

    public static CandidateResource toResourceFromEntity(Candidate entity) {
        return new CandidateResource(
                entity.getDeveloper().getFirstName(),
                entity.getDeveloper().getLastName(),
                entity.getDeveloper().getDescription(),
                entity.getDeveloper().getId(),
                entity.getProject().getId()

        );
    }
}
