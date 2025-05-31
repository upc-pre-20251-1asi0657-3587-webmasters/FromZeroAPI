package com.fromzero.backend.candidatesManagement.domain.model.commands;

public record SelectCandidateCommand(Long candidateId, Long projectId) {

    public SelectCandidateCommand {
        if (candidateId == null ) {
            throw new IllegalArgumentException("Candidate ID must not be null");
        }
        System.out.println("project ID: " + projectId);
        if(projectId == null) {
            throw new IllegalArgumentException("Project ID must not be null");
        }
    }

}
