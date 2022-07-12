package service;

import com.simple.interest.servicios.domain.InterestCalculate;
import com.simple.interest.servicios.domain.InterestCalculateResponse;
import com.simple.interest.servicios.repository.InterestRepository;
import com.simple.interest.servicios.service.InterestServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = { InterestServiceImpl.class })
public class InterestServiceCalculateTests {
  @Autowired
  InterestServiceImpl interestService;

  @MockBean
  InterestRepository mockInterestRepository;

  @Test
  public void shouldCalculateAndResponseAListOfThreeInterests() {
    InterestCalculate calculateInterest = new InterestCalculate();
    calculateInterest.setAmount(100.0);
    calculateInterest.setTerms(3);
    calculateInterest.setRate(0.1);

    List<InterestCalculateResponse> calculateInterestResponse = interestService.calculate(calculateInterest);

    assertEquals(calculateInterestResponse.size(), 3);
  }

  @Test
  public void shouldTheSumOfAllItemsShouldBeEqualToAmountPlusInterest () {
    InterestCalculate calculateInterest = new InterestCalculate();
    Double rate = 10.0;
    calculateInterest.setAmount(100.0);
    calculateInterest.setTerms(3);
    calculateInterest.setRate(rate);

    List<InterestCalculateResponse> calculateInterestResponse = interestService.calculate(calculateInterest);

    Double sum = 0.0;

    for (InterestCalculateResponse item : calculateInterestResponse) {
      sum += item.getAmount();
    }

    Double shouldBe = calculateInterest.getAmount() + (calculateInterest.getAmount() * calculateInterest.getRate() / 100);

    assertEquals(sum, shouldBe);
  }
}
