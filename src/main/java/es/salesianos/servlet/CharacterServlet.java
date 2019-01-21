package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.DtoActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.service.FilmActorService;


public class CharacterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FilmActorService service = new FilmActorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String role = req.getParameter("role");
		if (role != null) {
			DtoActorFilm selectFilmActor = service.filterAllFilmActor(role);
			req.setAttribute("selectFilmActor", selectFilmActor);
			System.out.println(selectFilmActor.getName());
		}
		
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/roleSearcher.jsp");
		dispatcher.forward(req, resp);
	}
}
