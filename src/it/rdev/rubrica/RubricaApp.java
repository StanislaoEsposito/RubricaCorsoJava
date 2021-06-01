package it.rdev.rubrica;

import java.util.ArrayList;
import java.util.List;

import it.rdev.rubrica.controller.RubricaController;
import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.ui.AppFrame;

public class RubricaApp {

	public static void main(String[] strings) {
		// trovare un modo per gestire indirizzi email e numeri di telefono 
		// leggere(Stream) e scrivere su un file di testo(append)
		//1 aggiungere numeri di cellulare e email sul db
		// dal file di configurazione decidere il tipo di persistenza da usare se da file txt o da db
		
		List<String> phone_numbers = new ArrayList<String>();
		phone_numbers.add("3889834556");
		List<String> emails = new ArrayList<String>();
		emails.add("michele.verdi@libero.it");
		Contact o1 = new Contact()
					.setName("Danilo")
					.setSurname("Di nuzzo")
					.setPhoneNumbers(phone_numbers)
					.setEmails(emails);
		
		Contact o2 = new Contact()
				.setName("Stanislao")
				.setSurname("Esposito")
				.setPhoneNumbers(phone_numbers)
				.setEmails(emails);

		
		RubricaController rb = new RubricaController();
		
		rb.addContact(o1);
		rb.addContact(o1);
		rb.addContact(o2);
		rb.removeContact(o1);
		
		//new AppFrame().setVisible(true);
	}
	
}
