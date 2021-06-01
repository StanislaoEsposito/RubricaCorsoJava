package it.rdev.rubrica.model;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String surname;
	private List<String> phoneNumbers;
	private List<String> emails;
	
	
	public Contact() {}

	public String getName() {
		return name;
	}
	public Contact setName(String name) {
		this.name = name;
		return this;
	}
	public String getSurname() {
		return surname;
	}
	public Contact setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public Contact setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
		return this;
	}
	public List<String> getEmails() {
		return emails;
	}
	public Contact setEmails(List<String> emails) {
		this.emails = emails;
		return this;
	}
	public Integer getId() {
		return id;
	}
	public Contact setId(Integer id) {
		this.id = id;
		return this;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", surname=" + surname + ", phoneNumbers=" + phoneNumbers
				+ ", emails=" + emails + "]";
	}
	
}
