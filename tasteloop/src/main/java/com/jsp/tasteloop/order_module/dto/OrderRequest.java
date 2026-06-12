package com.jsp.tasteloop.order_module.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class OrderRequest {
    private Integer userId;
}
