package com.fromzero.backend.candidatesManagement.application.internal.commandservices;

import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.candidatesManagement.domain.model.commands.ApplyToProjectCommand;
import com.fromzero.backend.candidatesManagement.domain.model.commands.SelectCandidateCommand;
import com.fromzero.backend.candidatesManagement.domain.services.CandidateCommandService;
import com.fromzero.backend.candidatesManagement.infrastructure.persistence.jpa.repositories.CandidateRepository;
import com.fromzero.backend.projects.infrastructure.persistence.jpa.repositories.ProjectRepository;
import com.fromzero.backend.user.infrastructure.persistence.jpa.repositories.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class CandidatesManagementCommandServiceImpl implements CandidateCommandService {
    private final ProjectRepository projectRepository;
    private final DeveloperRepository developerRepository;
    private final CandidateRepository candidateRepository;

    public CandidatesManagementCommandServiceImpl(ProjectRepository projectRepository, DeveloperRepository developerRepository,
                                                  CandidateRepository candidateRepository) {
        this.projectRepository = projectRepository;
        this.developerRepository = developerRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Optional<Candidate> handle(ApplyToProjectCommand command) {
        var project = projectRepository.findById(command.projectId())
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        var developer = developerRepository.findById(command.developerId())
                .orElseThrow(() -> new IllegalArgumentException("Developer not found"));

        if (project == null || developer == null) return Optional.empty();

        // to check if the candidate already applied to the project
        boolean alreadyApplied = candidateRepository
                .existsByProjectIdAndDeveloperId(command.projectId(), command.developerId());
        if (alreadyApplied){
            throw new IllegalArgumentException("Candidate already applied to this project");
        }

        var candidate = new Candidate(developer, project);
        candidateRepository.save(candidate);

        return Optional.of(candidate);
    }

    @Override
    public Optional<Candidate> handle(SelectCandidateCommand command) {
        var candidate = candidateRepository.findCandidateByProjectIdAndDeveloperId(command.projectId(), command.candidateId())
                .orElseThrow(() -> new IllegalArgumentException("Candidate not found for the specified project and candidate ID"));

        var project = projectRepository.findById(command.projectId())
                .orElseThrow(() -> new IllegalArgumentException("Project doesn't exist or not found"));


        if (!Objects.equals(candidate.getProject().getId(), command.projectId())) {
            throw new IllegalArgumentException("Candidate does not belong to the specified project");
        }

        if (project.getDeveloper() != null) {
            throw new IllegalStateException("This project already has a developer assigned");
        }

        candidate.setSelected(true);
        project.setDeveloper(candidate.getDeveloper());

        candidateRepository.save(candidate);
        projectRepository.save(project);

        return Optional.of(candidate);
    }


}
