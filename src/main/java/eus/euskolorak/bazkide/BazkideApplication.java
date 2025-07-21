package eus.euskolorak.bazkide;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BazkideApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazkideApplication.class, args);

		log.trace("Arrancando trace");
		log.debug("Arrancando debug");
		log.info("Arrancando info");
		log.warn("Arrancando warn");
		log.error("Arrancando error");

	}

}
