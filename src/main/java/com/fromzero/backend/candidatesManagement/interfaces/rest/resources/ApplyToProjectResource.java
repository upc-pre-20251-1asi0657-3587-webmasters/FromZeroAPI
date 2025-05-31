package com.fromzero.backend.candidatesManagement.interfaces.rest.resources;

public record ApplyToProjectResource(
    Long developerId
) {
    public ApplyToProjectResource {
        if (developerId == null) {
            throw new NullPointerException("developerId is null");
        }
    }
}
