package com.fromzero.backend.projects.domain.state;

import com.fromzero.backend.projects.domain.model.aggregates.Project;
import com.fromzero.backend.projects.domain.valueobjects.ProjectStateEnum;

public class InProcessState implements ProjectState{

    @Override
    public void startRecruitmentProcess(Project project) {
        throw new IllegalStateException("Cannot start recruitment process while project is in process");
    }

    @Override
    public void startProject(Project project) {
        throw new IllegalStateException("Cannot start project while project is in process");
    }

    @Override
    public void completeProject(Project project) {
        System.out.println("Completing project " + project.getName());
        project.setState(ProjectStateEnum.COMPLETED);

    }
}
