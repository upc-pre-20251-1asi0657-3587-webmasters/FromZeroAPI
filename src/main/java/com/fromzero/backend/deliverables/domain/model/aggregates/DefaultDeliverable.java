package com.fromzero.backend.deliverables.domain.model.aggregates;

import com.fromzero.backend.projects.domain.valueobjects.ProjectType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DefaultDeliverable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectType projectType;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int weeksToComplete;

    @Column(nullable = false)
    private int orderNumber;


    public DefaultDeliverable() {}

    public DefaultDeliverable(ProjectType projectType, String name, String description, int weeksToComplete, int orderNumber) {
        this.projectType = projectType;
        this.name = name;
        this.description = description;
        this.weeksToComplete = weeksToComplete;
        this.orderNumber = orderNumber;
    }



}
