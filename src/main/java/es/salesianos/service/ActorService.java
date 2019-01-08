package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActorRepository;

public class ActorService {

	private ActorRepository repository = new ActorRepository();

	public List<Actor> filterAllActor(int From, int To) {
		return repository.filterAllActor(From, To);
	}

	public List<Actor> selectAllActor() {
		return repository.selectAllActor();
	}

	public void insert(Actor actor) {
		repository.insert(actor);

	}

	public void delete(Actor actor) {
		repository.delete(actor);

	}

}
