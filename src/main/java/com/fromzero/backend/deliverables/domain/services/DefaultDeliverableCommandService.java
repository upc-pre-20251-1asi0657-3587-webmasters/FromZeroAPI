package com.fromzero.backend.deliverables.domain.services;

import com.fromzero.backend.deliverables.domain.model.commands.SeedDefaultDeliverablesCommand;

public interface DefaultDeliverableCommandService {
    void handle(SeedDefaultDeliverablesCommand command);
}
