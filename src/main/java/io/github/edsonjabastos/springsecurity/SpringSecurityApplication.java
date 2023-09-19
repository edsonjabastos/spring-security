package io.github.edsonjabastos.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@RestController
	class HttpController {
		@GetMapping("/public")
		String publicRoute() {
			return "<h1>This is a public route, feel free to look around 🔓 </h1>";
		}
		@GetMapping("/private")
		String privateRoute() {
			return "<h1>This is a private route, only authorized requisitions con access... 🔒 </h1>";
		}
	}

}
