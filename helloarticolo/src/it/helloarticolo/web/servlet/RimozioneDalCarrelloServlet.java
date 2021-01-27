package it.helloarticolo.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloarticolo.model.Articolo;
import it.helloarticolo.service.MyServiceFactory;
import it.helloarticolo.service.articolo.ArticoloService;

@WebServlet("/RimozioneDalCarrelloServlet")
public class RimozioneDalCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
       
   
    public RimozioneDalCarrelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		String parametroDellArticoloCheVoglioRimuovereDalCarrello = request.getParameter("idDaInviareComeParametro");
		Long idInput = Long.parseLong(parametroDellArticoloCheVoglioRimuovereDalCarrello);
		try {
			List<Articolo> lista = articoloServiceInstance.listCarrello();
			Articolo artticoloDaRimuovere = articoloServiceInstance.get(idInput);
			int totaleCarrello = articoloServiceInstance.totaleCarrello();
			if (articoloServiceInstance.rimuoviDaCarrello(artticoloDaRimuovere) == 1) {
				String messaggioConferma = "L'articolo è stato rimosso dal carrello!";
				request.setAttribute("messaggioConfermaDaInviare", messaggioConferma);
				destinazione = "carrello.jsp";
			} else {
				String messaggioErrore = "Non è stato possibile rimuovere l'articolo dal carrello.";
				request.setAttribute("messaggioErroreDaInviare", messaggioErrore);
				destinazione = "carrello.jsp";
			}
			request.setAttribute("listaCarrelloDaInviare", lista);
			request.setAttribute("totaleCarrello", totaleCarrello);
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
