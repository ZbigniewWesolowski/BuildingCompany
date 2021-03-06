package com.buildingcompany.controller.dto.valuation;


import com.buildingcompany.model.DocumentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class CreateUpdateValuationDto {
        private DocumentStatusEnum status;
        private Integer customerId;
        private Integer projectId;
}
