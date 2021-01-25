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

@WebServlet("/ListaArticoliServlet")
public class ListaArticoliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
       
    public ListaArticoliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String destinazione = null;
		
		try {
			List<Articolo> listaArticoli = articoloServiceInstance.list();
			if (listaArticoli.isEmpty()) {
				String messaggioDaInviareAPagina = "La lista degli articoli attualmente non è disponibile, riprovare più tardi.";
				request.setAttribute("messaggioDIErrore", messaggioDaInviareAPagina);
				destinazione = "index.jsp";
			} else {
				request.setAttribute("listaDaInviare", listaArticoli);
				destinazione = "vistaArticoli.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
