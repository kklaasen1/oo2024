package ee.tlu.salat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalatApplication.class, args);
	}

}


//kodus numbritega list, get, post, delete ja pute peavad olemas olema, oma vabalt valitud entity (autod, loomad, raamatukogu
// või midagi mis on varem kasutatud), controller
// uue projekti alustamiseks start.spring.io --> uus nimi (salat asemel kodutoo1)
