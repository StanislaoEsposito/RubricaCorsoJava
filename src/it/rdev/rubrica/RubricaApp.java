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
		List<String> numbers = new ArrayList<String>();
		numbers.add("3889834556");
		List<String> emails = new ArrayList<String>();
		emails.add("michele.verdi@libero.it");
		Contact o1 = new Contact()
					.setId(3)
					.setName("Michele")
					.setSurname("Verdi")
					.setPhoneNumbers(numbers)
					.setEmails(emails);
		System.out.println(o1);
		
		RubricaController rb = new RubricaController();
		
		rb.addContact(o1);
		rb.removeContact(o1);
		
		new AppFrame().setVisible(true);
	}
	
}
