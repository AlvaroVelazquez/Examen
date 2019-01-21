package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Film;

public class PeliculaAssembler {

	
	public static Film assemblePeliculaFrom(HttpServletRequest req) {
		Film pelicula = new Film();
		String codDirector = req.getParameter("codDirector");
		System.out.println(codDirector + " llega");
		if(null != codDirector) {
			pelicula.setCodDirector(Integer.parseInt(codDirector));
		}
		String title = req.getParameter("title");
		pelicula.setTitle(title);
		return pelicula;
	}
	
}
