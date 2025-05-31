package com.fromzero.backend.projects.domain.state;

import com.fromzero.backend.projects.domain.model.aggregates.Project;

public class CompletedState implements ProjectState {
    @Override
    public void startRecruitmentProcess(Project project) {
        throw new IllegalStateException("Cannot start recruitment process while project is completed");
    }

    @Override
    public void startProject(Project project) {
        throw new IllegalStateException("Cannot start project while project is completed");
    }

    @Override
    public void completeProject(Project project) {
        throw new IllegalStateException("Cannot complete project while project is completed");
    }
}
