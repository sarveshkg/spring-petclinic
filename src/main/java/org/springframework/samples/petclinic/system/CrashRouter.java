package org.springframework.samples.petclinic.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.vet.VetsHandler;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Profile("webflux")
@Configuration
public class CrashRouter {

	@Bean
	public RouterFunction<ServerResponse> crash(VetsHandler vetsHandler) {

		return RouterFunctions
			.route(RequestPredicates.GET("/oups"), vetsHandler::vets)
			.andRoute(RequestPredicates.GET("/vets.html"), request -> {
				throw new RuntimeException("Expected: controller used to showcase what "
		                + "happens when an exception is thrown");
			});
	}

}
