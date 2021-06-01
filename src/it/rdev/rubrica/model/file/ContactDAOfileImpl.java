package it.rdev.rubrica.model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.model.ContactDAO;


public class ContactDAOfileImpl implements ContactDAO{

	@Override
	public boolean persist(Contact t) throws SQLException {
		File inputFile  = new File("C:\\Users\\stani\\Documents\\rubrica.txt");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				if (currentLine.equals(t.getName()+", "+t.getSurname()+", "+t.getPhoneNumbers()+", "+t.getEmails())) {
					System.err.println("riga già inserita");
					return false;
				}
			}
			
	        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\stani\\Documents\\rubrica.txt", true));
	        writer.write(t.getName()+", "+t.getSurname()+", "+t.getPhoneNumbers()+", "+t.getEmails());
	        writer.newLine();
	        //String stampa = t.getName()+", "+t.getSurname()+", "+t.getPhoneNumbers()+", "+t.getEmails();
	        writer.close();
	        System.out.println("File scritto correttamente");
	        leggifile();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

	private static void leggifile() {
	    try {
	        File myObj = new File("C:\\Users\\stani\\Documents\\rubrica.txt");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          System.out.println(data);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }

	}

	@Override
	public boolean delete(Contact t) throws SQLException {
		File tempFile = new File("C:\\Users\\stani\\Documents\\myTempFile.txt");
		File inputFile  = new File("C:\\Users\\stani\\Documents\\rubrica.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String lineToRemove = t.getName()+", "+t.getSurname()+", "+t.getPhoneNumbers()+", "+t.getEmails();
			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
			    String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(lineToRemove)) {
			    	continue;
			    }
			    writer.write(currentLine);
			    writer.newLine();
			}
			
			writer.close();
			reader.close(); 
			ricopia();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private void ricopia() {
		File tempFile = new File("C:\\Users\\stani\\Documents\\myTempFile.txt");
		File inputFile  = new File("C:\\Users\\stani\\Documents\\rubrica.txt");
	      try {
	    	  BufferedReader reader = new BufferedReader(new FileReader(tempFile));
	    	  BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
	          String currentLine;
	          
	          while ((currentLine = reader.readLine()) != null) {
	        	  writer.write(currentLine);
	        	  writer.newLine();
	        	  }
	          writer.close();
			  reader.close(); ;
	      } catch(Exception e) {
	          System.out.println(e);
	      }

	}

	@Override
	public boolean update(Contact t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
