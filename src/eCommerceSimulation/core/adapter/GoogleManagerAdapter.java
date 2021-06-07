package eCommerceSimulation.core.adapter;

import eCommerceSimulation.core.abstracts.EmailService;
import eCommerceSimulation.googleMail.GoogleMailManager;

public class GoogleManagerAdapter implements EmailService {

	private GoogleMailManager googleMailManager;

	public GoogleManagerAdapter() {
		this.googleMailManager = new GoogleMailManager();
	}

	@Override
	public void send(String email, String message) {
		googleMailManager.send(email, message);

	}

}
