package com.fromzero.backend.deliverables.interfaces.rest.transform;

import com.fromzero.backend.deliverables.domain.model.aggregates.Deliverable;
import com.fromzero.backend.deliverables.interfaces.rest.resources.DeliverableResource;

public class DeliverableResourceFromEntityAssembler {
    public static DeliverableResource toResourceFromEntity(Deliverable deliverable) {
        return new DeliverableResource(
                deliverable.getId(),
                deliverable.getName(),
                deliverable.getDescription(),
                deliverable.getDeadline(),
                deliverable.getState(),
                deliverable.getDeveloperMessage(),
                deliverable.getProject().getId(),
                deliverable.getOrderNumber()
        );
    }
}