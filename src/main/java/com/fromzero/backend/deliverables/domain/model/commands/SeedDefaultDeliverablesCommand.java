package com.fromzero.backend.deliverables.domain.model.commands;

import com.fromzero.backend.projects.domain.valueobjects.ProjectTypeEnum;

public record SeedDefaultDeliverablesCommand(ProjectTypeEnum projectTypeEnum) {
}
