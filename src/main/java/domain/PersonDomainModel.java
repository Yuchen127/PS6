package domain;


import java.time.LocalDate;
import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {

    private  String FirstName;
    private  String LastName;
    private  String Street;
    private  int PostalCode;
    private  String City;
    private  LocalDate Birthday;
    private UUID PersonID;

    protected PersonDomainModel() {
	}


	public PersonDomainModel(String firstName, String lastName, String street, int postalCode, String city, LocalDate birthday) {
		super();
		this.setPersonID(UUID.randomUUID());		
		FirstName = firstName;
		LastName = lastName;
		Street = street;
		PostalCode = postalCode;
		City = city;
		Birthday = birthday;
	}

	


	public PersonDomainModel(PersonDomainModel per)
	{
		super();
		this.setPersonID(UUID.randomUUID());		
		FirstName = per.getFirstName();
		LastName = per.getLastName();
		PostalCode = per.getPostalCode();
		City = per.getCity();
		Birthday = per.getBirthday();
		
		
	}

	

	

	public LocalDate getBirthday() {
		return Birthday;
	}


	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getStreet() {
		return Street;
	}


	public void setStreet(String street) {
		Street = street;
	}


	public int getPostalCode() {
		return PostalCode;
	}


	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public PersonDomainModel(UUID PersontID) {
		super();
		PersonID = PersonID;		
	}

	public UUID getPersonID() {
		return PersonID;
	}
    private void setPersonID(UUID randomUUID) {
		PersonID = PersonID;
		
	}
}
