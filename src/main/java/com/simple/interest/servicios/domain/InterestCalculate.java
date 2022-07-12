package com.simple.interest.servicios.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class InterestCalculate {
  @Positive
  @NotNull
  @Schema(description = "The amount to be paid", defaultValue = "100")
  Double amount;

  @Positive
  @NotNull
  @Schema(description = "The number of payments", defaultValue = "3")
  Integer terms;

  @NotNull
  @Schema(description = "The interest rate", defaultValue = "5")
  Double rate;
}
