package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Film;
import es.salesianos.repository.FilmRepository;

public class FilmService {
	private FilmRepository repository = new FilmRepository();

	public List<Film> selectAllPelicula() {
		return repository.selectAllFilm();
	}

	public void insert(Film pelicula) {
		repository.insert(pelicula);

	}

	public void delete(Film pelicula) {
		repository.delete(pelicula);

	}
}
