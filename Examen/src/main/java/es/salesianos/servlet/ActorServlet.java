package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.service.Service;

public class ActorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actor actor = ActorAssembler.assembleActorFrom(req);
		service.insert(actor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codString = req.getParameter("cod");
		if (codString != null) {
			Actor actor = new Actor();
			int cod = Integer.parseInt(codString);
			actor.setCod(cod);
			service.delete(actor);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String parameter = req.getParameter("From");
		if (parameter != null) {
			int From = Integer.parseInt(req.getParameter("From"));
			int To = Integer.parseInt(req.getParameter("To"));
			List<Actor> listAllActores = service.filterAllActor(From, To);
			req.setAttribute("listAllActores", listAllActores);
		} else {
			List<Actor> listAllActores = service.selectAllActor();
			req.setAttribute("listAllActores", listAllActores);
		}
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addActor.jsp");
		dispatcher.forward(req, resp);
	}
}
