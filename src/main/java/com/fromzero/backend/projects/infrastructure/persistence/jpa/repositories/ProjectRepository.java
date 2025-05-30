package com.fromzero.backend.projects.infrastructure.persistence.jpa.repositories;


import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.projects.domain.model.aggregates.Project;
import com.fromzero.backend.projects.domain.valueobjects.ProjectState;
import com.fromzero.backend.user.domain.model.aggregates.Developer;
import com.fromzero.backend.user.domain.model.aggregates.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findAllByState(ProjectState state);
    List<Project> findAllByDeveloper(Developer developer);
    List<Project> findAllByEnterprise(Enterprise enterprise);

    @Query("SELECT c FROM Candidate c WHERE c.project.id = :projectId")
    List<Candidate> findAllCandidatesByProjectId(@Param("projectId") Long projectId);
}
