package com.fromzero.backend.deliverables.domain.model.commands;

import com.fromzero.backend.projects.domain.valueobjects.ProjectType;

public record SeedDefaultDeliverablesCommand(ProjectType projectType) {
}
