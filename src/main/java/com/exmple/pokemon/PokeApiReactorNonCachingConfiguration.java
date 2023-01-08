package com.exmple.pokemon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import skaro.pokeapi.client.PokeApiClient;
import skaro.pokeapi.client.PokeApiEntityFactory;
import skaro.pokeapi.client.ReactiveNonCachingPokeApiClient;
import skaro.pokeapi.resource.pokemon.Pokemon;

@Configuration
@Component
@Import(PokeApiReactorBaseConfiguration.class)
public class PokeApiReactorNonCachingConfiguration {
	
	
	private PokeApiClient pokeApiClient;
	
	

	public PokeApiReactorNonCachingConfiguration(@Lazy PokeApiClient pokeApiClient) {
		this.pokeApiClient = pokeApiClient;
	}

	@Bean
	public PokeApiClient pokeApiClient(PokeApiEntityFactory entityFactory) {
		return new ReactiveNonCachingPokeApiClient(entityFactory);
	}
	
	@Bean
	public ConnectionProvider connectionProvider() { 
		return// ConnectionProvider.builder("Auto refresh & no connection limit")
				ConnectionProvider.newConnection();
	}
	
	@Bean
	public HttpClient httpClient(ConnectionProvider connectionProvider) { 
		return 	//HttpClient.create().metrics(true, uriTagValueFunction)

		//HttpClient.newHttpClient();
				
				HttpClient.create(connectionProvider);
                //.compress(true).res
                //.resolver(DefaultAddressResolverGroup.INSTANCE);
		
		
	}
	
	public void printPokemon() {
		   pokeApiClient.getResource(Pokemon.class, "pikachu")
		      .map(pokemon -> String.format("%s has %d forms", pokemon.getName(), pokemon.getForms().size()))
		      .subscribe(System.out::println);
		}
}
