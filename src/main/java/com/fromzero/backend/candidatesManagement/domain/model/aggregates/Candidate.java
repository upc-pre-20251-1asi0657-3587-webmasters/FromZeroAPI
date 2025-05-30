package com.fromzero.backend.candidatesManagement.domain.model.aggregates;


import com.fromzero.backend.projects.domain.model.aggregates.Project;
import com.fromzero.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.fromzero.backend.user.domain.model.aggregates.Developer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Candidate extends AuditableAbstractAggregateRoot<Candidate> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="developer_id", nullable = false)
    private Developer developer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id", nullable = false)
    private Project project;


    private boolean selected = false;

    public Candidate() {

    }

    public Candidate(Developer developer, Project project) {
        this.developer = developer;
        this.project = project;
    }
}
