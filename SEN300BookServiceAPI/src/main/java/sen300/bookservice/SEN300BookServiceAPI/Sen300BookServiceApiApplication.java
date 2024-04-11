package sen300.bookservice.SEN300BookServiceAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// eureka
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class Sen300BookServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sen300BookServiceApiApplication.class, args);
	}

}
