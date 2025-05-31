package com.fromzero.backend.candidatesManagement.domain.services;

import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.candidatesManagement.domain.model.queries.GetAllCandidatesByProjectIdQuery;

import java.util.List;

public interface CandidateQueryService {
    List<Candidate> handle(GetAllCandidatesByProjectIdQuery query);
}
