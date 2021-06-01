package it.rdev.rubrica.model.impl.rdbms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.model.ContactDAO;

public class ContactDAOImpl extends AbstractDAO<Contact> implements ContactDAO {
	
	private final String TABLE_NAME = "contacts";
	private final String TABLE_NUMBERS = "email";
	private final String TABLE_EMAILS = "number";
	public List<Contact> getAll() {
		List<Contact> contacts = new ArrayList<>();
		try {
			ResultSet rs = this.executeQuery("SELECT id, name, surname FROM " + TABLE_NAME);
			while(rs.next()) {
				contacts.add(
						new Contact()
						.setId(rs.getInt("id"))
						.setName(rs.getString("name"))
						.setSurname(rs.getString("surname")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public boolean persist(Contact o) throws SQLException {
		try {
			this.executeInsert("INSERT INTO "+ TABLE_NAME + " VALUES (?,?,?)",
					o.getId(), o.getName(), o.getSurname() );

		for (int i = 0; i < o.getPhoneNumbers().size(); i++) {
			this.executeInsert("INSERT INTO "+ TABLE_NUMBERS + " VALUES (?,?)",
					o.getId(), o.getPhoneNumbers().get(i));
		}

		for (int i = 0; i < o.getEmails().size(); i++) {
			this.executeInsert("INSERT INTO "+ TABLE_EMAILS + " VALUES (?,?)",
					o.getId(), o.getEmails().get(i));
		}
		return true;
		} catch (SQLException e) {
			return false;
		}

	}

	@Override
	public boolean delete(Contact t) throws SQLException {
		try {
			this.executeUpdate("DELETE FROM "+ TABLE_NAME +" WHERE id = " + t.getId() );
			System.out.println("Rimosso");
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR SQL");
			return false;
		}
	}

	@Override
	public boolean update(Contact t) throws SQLException {
		return false;
	}

}

