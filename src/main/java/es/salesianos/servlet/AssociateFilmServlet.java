package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;
import es.salesianos.model.assembler.PeliculaAssembler;
import es.salesianos.service.ActorService;
import es.salesianos.service.FilmService;


public class AssociateFilmServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private ActorService actorService = new ActorService();
	private FilmService peliculaService = new FilmService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pelicula pelicula = PeliculaAssembler.assemblePeliculaFrom(req);
		peliculaService.insert(pelicula);
		doAction(req, resp);
	}
 
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codPelicula = req.getParameter("cod");
		
		req.setAttribute("codPelicula", codPelicula);
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Actor> listAllActores = actorService.selectAllActor();
		req.setAttribute("listAllActores", listAllActores);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/chooseActor.jsp");
		dispatcher.forward(req, resp);
	}
}