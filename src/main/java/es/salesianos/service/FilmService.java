package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Pelicula;
import es.salesianos.repository.FilmRepository;

public class FilmService {
	private FilmRepository repository = new FilmRepository();

	public List<Pelicula> selectAllPelicula() {
		return repository.selectAllPelicula();
	}

	public void insert(Pelicula pelicula) {
		repository.insert(pelicula);

	}

	public void delete(Pelicula pelicula) {
		repository.delete(pelicula);

	}
}
