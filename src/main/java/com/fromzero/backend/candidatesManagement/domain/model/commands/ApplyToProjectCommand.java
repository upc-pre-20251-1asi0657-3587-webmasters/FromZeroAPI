package com.fromzero.backend.candidatesManagement.domain.model.commands;

public record ApplyToProjectCommand(Long developerId, Long projectId) {

    public ApplyToProjectCommand {
        if (developerId == null || projectId == null) {
            throw new IllegalArgumentException("Developer ID and Project ID must not be null");
        }
    }
}
