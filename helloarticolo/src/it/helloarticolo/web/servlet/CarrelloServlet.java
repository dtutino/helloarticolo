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

@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
       
    public CarrelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;

		try {
			List<Articolo> listaArticoliCarrello = articoloServiceInstance.listCarrello();
			int totaleCarrello = articoloServiceInstance.totaleCarrello();
			if (listaArticoliCarrello.isEmpty()) {
				String messaggioDaInviareAPagina = "Il carrello è vuoto, aggiungi gli articoli per procedere al pagamento!";
				request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
				destinazione = "carrello.jsp";
			} else {
				request.setAttribute("listaCarrelloDaInviare", listaArticoliCarrello);
				destinazione = "carrello.jsp";
			}
			request.setAttribute("totaleCarrello", totaleCarrello);
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		String parametroDellArticoloCheVoglioInserireNelCarrello = request.getParameter("idDaInviareComeParametro");
		Long idInput = Long.parseLong(parametroDellArticoloCheVoglioInserireNelCarrello);
		try {
			List<Articolo> lista = articoloServiceInstance.list();
			Articolo artticoloDaAggiungere = articoloServiceInstance.get(idInput);
			if (articoloServiceInstance.aggiungiACarrello(artticoloDaAggiungere) == 1) {
				String messaggioConferma = "L'articolo è stato aggiunto al carrello!";
				request.setAttribute("messaggioConfermaDaInviare", messaggioConferma);
				destinazione = "vistaArticoli.jsp";
			} else {
				String messaggioErrore = "Non è stato possibile inserire l'articolo nel carrello.";
				request.setAttribute("messaggioErroreDaInviare", messaggioErrore);
				destinazione = "vistaArticoli.jsp";
			}
			request.setAttribute("listaDaInviare", lista);
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
