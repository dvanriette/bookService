package sen300.basketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// eureka
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// eureka
@SpringBootApplication
//@EnableDiscoveryClient
public class BasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketApplication.class, args);
	}

}
