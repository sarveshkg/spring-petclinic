package org.springframework.samples.petclinic.vet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Profile("webflux")
@Configuration
public class VetsRouter {

	@Bean
	public RouterFunction<ServerResponse> route(VetsHandler vetsHandler) {

		return RouterFunctions
			.route(RequestPredicates.GET("/vets").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), vetsHandler::vets)
			.andRoute(RequestPredicates.GET("/vets.html"), vetsHandler::vetsHtml);
	}
	
}