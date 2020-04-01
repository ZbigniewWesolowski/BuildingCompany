package com.buildingcompany.controller.dto.salesDocument;

import com.buildingcompany.model.DocumentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesDocumentDto {
    private Integer id;
    private DocumentStatusEnum status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Integer projectId;
}
