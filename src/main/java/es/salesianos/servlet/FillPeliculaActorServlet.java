package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.FilmActor;
import es.salesianos.model.assembler.FilmActorAssembler;
import es.salesianos.service.FilmActorService;

public class FillPeliculaActorServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private FilmActorService service = new FilmActorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmActor peliculaActor = FilmActorAssembler.assemblePeliculaActorFrom(req);
		service.insert(peliculaActor);
	}
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codFilm = req.getParameter("codFilm");
		String codActor = req.getParameter("codActor");
		req.setAttribute("codFilm", codFilm);
		req.setAttribute("codActor", codActor);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fillPeliculaActor.jsp");
		dispatcher.forward(req, resp);
	}
}
