package com.simple.interest.servicios.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class InterestCalculateResponse {
  @Schema(required = true)
  Integer payment_number;

  @Schema(required = true)
  Double amount;

  @Schema(required = true)
  Date payment_date;
}
