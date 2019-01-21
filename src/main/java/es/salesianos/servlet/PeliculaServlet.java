package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Film;
import es.salesianos.model.assembler.PeliculaAssembler;
import es.salesianos.service.FilmService;

public class PeliculaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FilmService service = new FilmService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Film pelicula = PeliculaAssembler.assemblePeliculaFrom(req);
		service.insert(pelicula);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codString = req.getParameter("cod");

		if (null != codString) {
			Film pelicula = new Film();
			int cod = Integer.parseInt(codString);
			pelicula.setCod(cod);
			service.delete(pelicula);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Film> selectAllPelicula = service.selectAllPelicula();
		req.setAttribute("listAllPeliculas", selectAllPelicula);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pelicula.jsp");
		dispatcher.forward(req, resp);
	}
}
