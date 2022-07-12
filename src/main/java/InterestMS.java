import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = "com.simple.interest")
public class InterestMS {

	public static void main(String[] args) {
		SpringApplication.run(InterestMS.class, args);
	}

}
