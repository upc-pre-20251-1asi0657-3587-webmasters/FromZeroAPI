package com.fromzero.backend.candidatesManagement.application.internal.queryservices;

import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.candidatesManagement.domain.model.queries.GetAllCandidatesByProjectIdQuery;
import com.fromzero.backend.candidatesManagement.domain.services.CandidateQueryService;
import com.fromzero.backend.candidatesManagement.infrastructure.persistence.jpa.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManagementQueryServiceImpl implements CandidateQueryService {

    private final CandidateRepository candidateRepository;

    public CandidateManagementQueryServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Candidate> handle(GetAllCandidatesByProjectIdQuery query) {
        return candidateRepository.findAllByProjectId(query.projectId());
    }
}
