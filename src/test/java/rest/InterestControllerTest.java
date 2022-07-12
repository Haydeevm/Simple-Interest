package rest;


import com.simple.interest.servicios.domain.InterestCalculate;
import com.simple.interest.servicios.rest.InterestControllerImpl;
import com.simple.interest.servicios.service.InterestServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(properties = "spring.main.lazy-initialization=true",
classes = {InterestControllerImpl.class})
public class InterestControllerTest {
  @Autowired
  InterestControllerImpl interestController;

  @MockBean
  InterestServiceImpl interestService;

  @Test
  public void shouldCallServiceListMethod () {
    interestController.list();
    verify(interestService, times(1)).list();
  }

  @Test
  public void shouldCallServiceCalculateMethod () {
    interestController.calculate(new InterestCalculate());
    verify(interestService, times(1)).calculate(Mockito.any());
  }

  @Test
  public void shouldCallRepositorySaveMethodOneTime() {
    InterestCalculate calculateInterest = new InterestCalculate();
    calculateInterest.setAmount(100.0);
    calculateInterest.setTerms(3);
    calculateInterest.setRate(0.1);

    interestController.calculate(calculateInterest);

    verify(interestService, times(1)).save(Mockito.any());
  }
}
