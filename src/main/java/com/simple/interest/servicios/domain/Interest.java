package com.simple.interest.servicios.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "INTEREST")
@Data
public class Interest {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(columnDefinition = "text")
  private String request;

  @Column(columnDefinition = "text")
  private String response;

  public static Interest create(String request, String response) {
    Interest interest = new Interest();
    interest.setRequest(request);
    interest.setResponse(response);
    return interest;
  }
}