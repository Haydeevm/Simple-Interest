package com.simple.interest.servicios.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.interest.servicios.domain.Interest;
import com.simple.interest.servicios.domain.InterestCalculate;
import com.simple.interest.servicios.domain.InterestCalculateResponse;
import com.simple.interest.servicios.service.InterestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/interest")
@Tag(name = "Interest")
@Slf4j
public class InterestControllerImpl implements InterestController {
  @Autowired
  private InterestService interestService;

  @GetMapping("list")
  @Operation(summary = "List all interests")
  public List<Interest> list() {
    return interestService.list();
  }

  @PostMapping("calculate")
  @Operation(summary = "Calculate interest")
  public List<InterestCalculateResponse> calculate(@Valid @RequestBody InterestCalculate body) {
    List<InterestCalculateResponse> response = interestService.calculate(body);

    ObjectMapper Obj = new ObjectMapper();
    try {
      this.interestService.save(Interest.create(
          Obj.writeValueAsString(body),
          Obj.writeValueAsString(response)));
    } catch (IOException e) {
      log.error("Error saving request: " + e.getMessage(), e);
    }

    return response;
  }
}
