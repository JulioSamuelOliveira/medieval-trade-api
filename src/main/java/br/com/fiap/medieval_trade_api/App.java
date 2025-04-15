package br.com.fiap.medieval_trade_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(
	title = "Medieval Trade API", 
	version = "v1", 
	description = "API desenvolvida em Java que simula um mercado medieval, onde personagens podem cadastrar, comprar, vender e trocar itens mágicos como espadas encantadas, elixires e grimórios. Ideal para aplicações de RPG ou como base para projetos com foco em lógica de negócios, modelagem e APIs RESTful.", 
	contact = @Contact(name = "Julio Oliveira & Leonardo Pereira", email = "dev.juliosamueloliveira@gmail.com & leosilper@gmail@gmail.com")))
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
