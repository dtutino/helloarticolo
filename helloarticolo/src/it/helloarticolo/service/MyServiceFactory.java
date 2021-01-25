package it.helloarticolo.service;

import it.helloarticolo.dao.MyDaoFactory;
import it.helloarticolo.service.articolo.ArticoloService;
import it.helloarticolo.service.articolo.ArticoloServiceImpl;

public class MyServiceFactory {
	// rendiamo questo factory SINGLETON
		private static ArticoloService ARTICOLO_SERVICE_INSTANCE;

		public static ArticoloService getArticoloServiceInstance() {
			if (ARTICOLO_SERVICE_INSTANCE == null)
				ARTICOLO_SERVICE_INSTANCE = new ArticoloServiceImpl();

			ARTICOLO_SERVICE_INSTANCE.setArticoloDAO(MyDaoFactory.getArticoloDAOInstance());

			return ARTICOLO_SERVICE_INSTANCE;
		}
}
