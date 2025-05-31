package com.fromzero.backend.candidatesManagement.interfaces.rest;

import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.candidatesManagement.domain.model.commands.ApplyToProjectCommand;
import com.fromzero.backend.candidatesManagement.domain.model.commands.SelectCandidateCommand;
import com.fromzero.backend.candidatesManagement.domain.model.queries.GetAllCandidatesByProjectIdQuery;
import com.fromzero.backend.candidatesManagement.domain.services.CandidateCommandService;
import com.fromzero.backend.candidatesManagement.domain.services.CandidateQueryService;
import com.fromzero.backend.candidatesManagement.interfaces.rest.resources.ApplyToProjectResource;
import com.fromzero.backend.candidatesManagement.interfaces.rest.resources.CandidateResource;
import com.fromzero.backend.projects.domain.model.aggregates.Project;
import com.fromzero.backend.user.domain.model.aggregates.Developer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CandidatesManagementControllerTest {

    @Mock
    private CandidateCommandService candidateCommandService;

    @Mock
    private CandidateQueryService candidateQueryService;

    @InjectMocks
    private CandidatesManagementController candidatesManagementController;

    private Developer developer;
    private Project project;
    private Candidate candidate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        developer = new Developer();
        developer.setId(1L);
        developer.setFirstName("Juan");
        developer.setLastName("Jose");
        developer.setDescription("Java Developer");

        project = new Project();
        project.setId(1L);

        candidate = new Candidate();
        candidate.setId(1L);
        candidate.setDeveloper(developer);
        candidate.setProject(project);
        candidate.setSelected(false);
    }

    @Test
    void getAllCandidatesByProjectId() {
        when(candidateQueryService.handle(any(GetAllCandidatesByProjectIdQuery.class)))
                .thenReturn(List.of(new Candidate(developer, project)));

        assertNotNull(candidatesManagementController.getAllCandidatesByProjectId(project.getId()));
    }


    @Test
    void selectCandidate() {
        Candidate candidate = new Candidate(developer, project);
        when(candidateCommandService.handle(any(SelectCandidateCommand.class)))
                .thenReturn(Optional.of(candidate));

        assertNotNull(candidatesManagementController.selectCandidate(project.getId(), 1L));
    }


    @Test
    void applyToProject() {
        ApplyToProjectResource resource = new ApplyToProjectResource(developer.getId());
        Candidate candidate = new Candidate(developer, project);

        when(candidateCommandService.handle(any(ApplyToProjectCommand.class)))
                .thenReturn(Optional.of(candidate));

        assertNotNull(candidatesManagementController.applyToProject(project.getId(), resource));
    }

}