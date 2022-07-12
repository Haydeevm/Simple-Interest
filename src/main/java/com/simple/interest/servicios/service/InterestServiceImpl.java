package com.simple.interest.servicios.service;

import com.simple.interest.servicios.domain.Interest;
import com.simple.interest.servicios.domain.InterestCalculate;
import com.simple.interest.servicios.domain.InterestCalculateResponse;
import com.simple.interest.servicios.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Validated
public class InterestServiceImpl implements InterestService {

    private InterestRepository interestRepository;

    public List<Interest> list() {
        return interestRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public Interest save(@NotNull @Valid Interest interest) {
        return interestRepository.save(interest);
    }

    public List<InterestCalculateResponse> calculate(@Valid InterestCalculate body) {
        List<InterestCalculateResponse> response = new ArrayList<>();

        Double amount = body.getAmount();
        Integer terms = body.getTerms();
        Double rate = body.getRate();

        Double totalToPay = amount + (rate / 100) * amount;
        Double totalPerPayment = totalToPay / terms;

        for (int i = 1; i <= terms; i++) {
            InterestCalculateResponse calculateInterestResponse = new InterestCalculateResponse();
            calculateInterestResponse.setPayment_number(i);
            calculateInterestResponse.setAmount(totalPerPayment);
            calculateInterestResponse.setPayment_date(new Date());
            response.add(calculateInterestResponse);
        }

        return response;
    }
}
