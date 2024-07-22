package com.pms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor@JsonIgnoreProperties
@Builder
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
