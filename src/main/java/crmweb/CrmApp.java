package crmweb;

import crmweb.controller.CustomerController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.post;

public class CrmApp {

	public static void main(String[] args) {
		Javalin app = Javalin.create();
		app._conf.addStaticFiles("C:\\Users\\admin\\Desktop\\maven\\resources", Location.EXTERNAL);
		app.routes(() -> {
			post(Path.Web.CUSTOMER, CustomerController.selectCustomer);
			post(Path.Web.CREATE_CUSTOMER, CustomerController.createCustomer);
		});

		app.error(404, ViewUtil.notFound);

		app.start(7070);
	}
}