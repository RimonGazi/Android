package com.rimon.rsa.manrinaFragment;

public class RegisterData {
	String firstName, lastName, chapter, category, email, mantinada;

	public RegisterData(String firstName, String lastName, String chapter,
			String category, String email, String mantinada) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.chapter = chapter;
		this.category = category;
		this.email = email;
		this.mantinada = mantinada;
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

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMantinada() {
		return mantinada;
	}

	public void setMantinada(String mantinada) {
		this.mantinada = mantinada;
	}
}
