package it.rdev.rubrica.controller;

import java.sql.SQLException;
import java.util.List;

import it.rdev.rubrica.config.ConfigKeys;
import it.rdev.rubrica.config.Configuration;
import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.model.ContactDAO;
import it.rdev.rubrica.model.file.ContactDAOfileImpl;
import it.rdev.rubrica.model.impl.rdbms.ContactDAOImpl;

public class RubricaController {
	
	private ContactDAO dao;
	private ContactDAO daoFile;
	public RubricaController() {
		dao = new ContactDAOImpl();
		daoFile = new ContactDAOfileImpl();
	}

	public List<Contact> getContactList() {
		return dao.getAll();
	}
	
	public String addContact(Contact c) {
		String view = "LIST";
		// altri controlli
		try {
			if (Configuration.getInstance().getValue(ConfigKeys.PERSISTENCE_TYPE).equals("DB")) {
				dao.persist(c);
			}else if (Configuration.getInstance().getValue(ConfigKeys.PERSISTENCE_TYPE).equals("FILE")) {
				daoFile.persist(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			view = "LIST-ERROR";
		}
		return view;
	}

	public String removeContact(Contact c) {
		String view = "LIST";
		// altri controlli
		try {

			if (Configuration.getInstance().getValue(ConfigKeys.PERSISTENCE_TYPE).equals("DB")) {
				dao.delete(c);
			}else if (Configuration.getInstance().getValue(ConfigKeys.PERSISTENCE_TYPE).equals("FILE")) {
				daoFile.delete(c);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			view = "LIST-ERROR";
		}
		return view;
	}
}
