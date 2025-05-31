package com.fromzero.backend.projects.domain.state;

import com.fromzero.backend.projects.domain.model.aggregates.Project;

public interface ProjectState {

    void startRecruitmentProcess(Project project);
    void startProject(Project project);
    void completeProject(Project project);
}
