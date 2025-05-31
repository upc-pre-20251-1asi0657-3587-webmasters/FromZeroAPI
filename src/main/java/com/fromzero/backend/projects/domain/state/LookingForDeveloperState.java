package com.fromzero.backend.projects.domain.state;

import com.fromzero.backend.projects.domain.model.aggregates.Project;
import com.fromzero.backend.projects.domain.valueobjects.ProjectStateEnum;

public class LookingForDeveloperState implements ProjectState {

    @Override
    public void startRecruitmentProcess(Project project) {
        System.out.println("Already looking for developers");
    }

    @Override
    public void startProject(Project project) {
        if (project.getDeveloper() == null) {
            throw new IllegalStateException("Can't start project without a developer assigned");
        }

       System.out.println("Starting project " + project.getName());
        project.setState(ProjectStateEnum.IN_PROCESS);
    }

    @Override
    public void completeProject(Project project) {
        throw new IllegalStateException("Cannot complete project while looking for developers");
    }
}
