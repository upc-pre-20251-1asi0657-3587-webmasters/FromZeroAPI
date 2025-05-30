package com.fromzero.backend.candidatesManagement.domain.services;

import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.candidatesManagement.domain.model.commands.ApplyToProjectCommand;
import com.fromzero.backend.candidatesManagement.domain.model.commands.SelectCandidateCommand;

import java.util.Optional;

public interface CandidateCommandService {
    Optional<Candidate> handle(ApplyToProjectCommand command);
    Optional <Candidate> handle(SelectCandidateCommand command);
}
