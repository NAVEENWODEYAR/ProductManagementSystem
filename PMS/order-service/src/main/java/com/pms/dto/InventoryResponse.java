package com.pms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor@JsonIgnoreProperties
@Builder
public class InventoryResponse {
    private String skuCode;
    @Getter
    private boolean isInStock;

}
