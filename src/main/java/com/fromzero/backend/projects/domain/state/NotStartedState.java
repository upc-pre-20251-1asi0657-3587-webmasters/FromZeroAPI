package com.fromzero.backend.projects.domain.state;

import com.fromzero.backend.projects.domain.model.aggregates.Project;
import com.fromzero.backend.projects.domain.valueobjects.ProjectStateEnum;

public class NotStartedState implements ProjectState {

    @Override
    public void startRecruitmentProcess(Project project) {
        System.out.println("Recruitment process started. Looking for developers");
        project.setState(ProjectStateEnum.LOOKING_FOR_DEVELOPERS);
    }

    @Override
    public void startProject(Project project) {
        throw new IllegalStateException("Can't start project before recruitment.");
    }

    @Override
    public void completeProject(Project project) {
        throw new IllegalStateException("Can't complete project before starting.");
    }
}
