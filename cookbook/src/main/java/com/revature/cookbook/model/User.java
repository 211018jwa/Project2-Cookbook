package com.revature.cookbook.model;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int id;

private String username;

private String password;

private String firstName;

private String lastName;

private String phoneNumber;

private String email;

private int age;

private String likedRecipes;			//Should be a string consisting of integers representing Recipe IDs separated by spaces. Ex: "1 223 412 451 123" etc

public User() {
	super();
	likedRecipes = ""; //Dont want this to be null. Just easier to handle that way 
}




public User(int id, String username, String password, String firstName, String lastName, String phoneNumber,
		String email, int age, String likedRecipes) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.age = age;
	this.likedRecipes = likedRecipes;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getLikedRecipe() {
	return likedRecipes;
}

public void setLikedRecipe(String likedRecipes) {
	this.likedRecipes = likedRecipes;
}

@Override
public int hashCode() {
	return Objects.hash(age, email, firstName, id, lastName, likedRecipes, password, phoneNumber, username);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return age == other.age && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
			&& id == other.id && Objects.equals(lastName, other.lastName) && likedRecipes == other.likedRecipes
			&& Objects.equals(password, other.password) && Objects.equals(phoneNumber, other.phoneNumber)
			&& Objects.equals(username, other.username);
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", age=" + age
			+ ", likedRecipe=" + likedRecipes + "]";
}


}
