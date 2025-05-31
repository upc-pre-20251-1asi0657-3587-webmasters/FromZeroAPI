package com.fromzero.backend.projects.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fromzero.backend.candidatesManagement.domain.model.aggregates.Candidate;
import com.fromzero.backend.projects.domain.model.commands.CreateProjectCommand;
import com.fromzero.backend.projects.domain.state.*;
import com.fromzero.backend.projects.domain.valueobjects.ProjectStateEnum;
import com.fromzero.backend.projects.domain.valueobjects.ProjectTypeEnum;
import com.fromzero.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.fromzero.backend.user.domain.model.aggregates.Developer;
import com.fromzero.backend.user.domain.model.aggregates.Enterprise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Project extends AuditableAbstractAggregateRoot<Project> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Setter
    private ProjectStateEnum state;


    @Setter
    private Double progress;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @Setter
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Candidate> candidates;

    //many to many relationship
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_programming_languages",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "programming_language_id")
    )
    @JsonManagedReference
    private List<ProgrammingLanguage> languages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_frameworks",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "framework_id")
    )
    @JsonManagedReference
    private List<Framework> frameworks;

    private ProjectTypeEnum type;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String budget;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String methodologies;

    public Project(CreateProjectCommand command){
        this.name=command.name();
        this.description=command.description();
        this.state= ProjectStateEnum.LOOKING_FOR_DEVELOPERS;
        this.progress=0.0;
        this.enterprise=command.enterprise();
        this.developer=null;
        this.languages=new ArrayList<>();
        this.frameworks=new ArrayList<>();
        this.type=command.type();
        this.budget=command.budget();
        this.methodologies=command.methodologies();

    }

    public Project() {
    }

    @Transient
    public ProjectState getStateHandler() {
        return switch (this.state) {
            case LOOKING_FOR_DEVELOPERS -> new LookingForDeveloperState();
            case NOT_STARTED -> new NotStartedState();
            case IN_PROCESS -> new InProcessState();
            case COMPLETED -> new CompletedState();
        };
    }
}