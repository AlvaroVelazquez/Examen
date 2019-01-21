package es.salesianos.model;


public class FilmActor {

	private int cache;
	private String role;
	private int codPelicula;
	private int codActor;
	private Actor actor;
	private Film pelicula;
	
	public int getCache() {
		return cache;
	}
	public void setCache(int cache) {
		this.cache = cache;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getCodFilm() {
		return codPelicula;
	}
	public void setCodFilm(int codPelicula) {
		this.codPelicula = codPelicula;
	}
	public int getCodActor() {
		return codActor;
	}
	public void setCodActor(int codActor) {
		this.codActor = codActor;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Film getFilm() {
		return pelicula;
	}
	public void setFilm(Film pelicula) {
		this.pelicula = pelicula;
	}
	
	
	
	
	
	
	
}
