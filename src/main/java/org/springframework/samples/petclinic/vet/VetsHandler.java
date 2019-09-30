package org.springframework.samples.petclinic.vet;

import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Profile("webflux")
@Component
public class VetsHandler {
	
    private final VetRepository vetsRespository;

    public VetsHandler(VetRepository vetsRepository) {
        this.vetsRespository = vetsRepository;
    }
	
	public Mono<ServerResponse> vets(ServerRequest request) {
		Vets vets = new Vets();
		vets.getVetList().addAll(vetsRespository.findAll());
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject(vets));
	}
	
	public Mono<ServerResponse> vetsHtml(ServerRequest request) {
        Vets vets = new Vets();
        vets.getVetList().addAll(vetsRespository.findAll());
        return ServerResponse.ok().render("vets/vetList", vets);
	}
	
}
