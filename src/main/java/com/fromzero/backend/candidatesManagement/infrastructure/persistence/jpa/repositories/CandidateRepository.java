package com.fromzero.backend.candidatesManagement.infrastructure.persistence.jpa.repositories;

import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.candidatesManagement.domain.model.queries.GetAllCandidatesByProjectIdQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findAllByProjectId(Long projectId);

    boolean existsByProjectIdAndDeveloperId(Long projectId, Long developerId);

    Optional<Candidate> findCandidateByProjectIdAndDeveloperId(Long projectId, Long developerId);
}
