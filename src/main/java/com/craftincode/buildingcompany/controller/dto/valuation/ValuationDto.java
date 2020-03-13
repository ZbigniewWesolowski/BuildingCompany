package com.craftincode.buildingcompany.controller.dto.valuation;

import com.craftincode.buildingcompany.model.DocumentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class ValuationDto {

        private Integer id;
        private DocumentStatusEnum status;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private Integer customerId;
        private Integer projectId;
}
