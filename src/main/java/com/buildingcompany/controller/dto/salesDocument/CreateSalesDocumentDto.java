package com.buildingcompany.controller.dto.salesDocument;

import com.buildingcompany.model.DocumentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSalesDocumentDto {
    private DocumentStatusEnum status;
    private Integer projectId;
}
