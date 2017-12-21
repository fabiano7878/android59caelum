package br.com.caelum.fj59.casadocodigo;

import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(Boot.class, args);
	}

}
