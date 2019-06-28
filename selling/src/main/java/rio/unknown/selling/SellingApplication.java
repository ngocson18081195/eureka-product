package rio.unknown.selling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"rio.unknown.*"})
public class SellingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellingApplication.class, args);
    }

}
