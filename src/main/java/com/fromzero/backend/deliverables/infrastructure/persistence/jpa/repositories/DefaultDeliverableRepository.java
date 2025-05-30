package com.fromzero.backend.deliverables.infrastructure.persistence.jpa.repositories;

import com.fromzero.backend.deliverables.domain.model.aggregates.DefaultDeliverable;
import com.fromzero.backend.projects.domain.valueobjects.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DefaultDeliverableRepository extends JpaRepository<DefaultDeliverable, Long> {

    int countByProjectType(ProjectType projectType);
}
