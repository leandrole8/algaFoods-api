package com.leandroreis.algafood.jpa;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.leandroreis.algafood.AlgafoodApiApplication;
import com.leandroreis.algafood.domain.model.Cozinha;
import com.leandroreis.algafood.domain.model.Restaurante;
import com.leandroreis.algafood.domain.repository.CozinhaRepository;
import com.leandroreis.algafood.domain.repository.RestauranteRepository;

public class ExclusaoRestauranteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = new Restaurante();
		restaurante.setId(4L);
		
		restauranteRepository.remover(restaurante);
		
	}

}
