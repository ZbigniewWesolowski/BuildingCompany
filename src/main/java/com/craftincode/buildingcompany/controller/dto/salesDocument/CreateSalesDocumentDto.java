package com.craftincode.buildingcompany.controller.dto.salesDocument;

import com.craftincode.buildingcompany.model.DocumentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSalesDocumentDto {
    private DocumentStatusEnum status;
    private Integer projectId;
}
