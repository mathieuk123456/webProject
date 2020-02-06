package com.webproject.entity;

import java.sql.Blob;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;
	@Column(name = "email")
	String email;
	@Column(name = "photo")
	Blob photo;
	
	public Student() {}
	public Student(int id) {
		this.id = id;
	}
	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean photoExists() {
		if(photo == null)
			return false;
		return true;
	}
	public Blob getPhoto() {
		return photo;
	}
	public String getBase64Photo() throws SQLException {
		if(photo == null)
			return null;
		else
			return DatatypeConverter.printBase64Binary( photo.getBytes(1, (int) photo.length() ));
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("<tr>");
		str.append("<th scope='row'>");
		str.append(id);
		str.append("</th>");
		str.append("<td>");
		str.append(firstName);
		str.append("</td>");
		str.append("<td>");
		str.append(lastName);
		str.append("</td>");
		str.append("<td>");
		str.append(email);
		str.append("</td>");
		str.append("<td>");
		str.append("<button class='delete' type=\"submit\" name='identifier' value='" + id + "'></button>");
		str.append("</td>");
		str.append("<td>");
		str.append("<button class='edit' type=\"submit\" name='identifier' value='" + id + "'></button>");
		str.append("</td>");
		str.append("</tr>");
		
		return str.toString();
	}
	public String toString(boolean b) {
		StringBuilder str = new StringBuilder();
		str.append("<tr>");
		str.append("<th scope='row'>");
		str.append(id);
		str.append("</th>");
		str.append("<td>");
		str.append("<input type=\"text\" value=\"" + firstName + "\">");
		str.append("</td>");
		str.append("<td>");
		str.append(lastName);
		str.append("</td>");
		str.append("<td>");
		str.append(email);
		str.append("</td>");
		str.append("<td>");
		str.append("<button class='delete' type=\"submit\" name='identifier' value='" + id + "'></button>");
		str.append("</td>");
		str.append("<td>");
		str.append("<button class='edit' type=\"submit\" name='identifier' value='" + id + "'></button>");
		str.append("</td>");
		str.append("</tr>");
		
		return str.toString();
	}
	
	
	
}
