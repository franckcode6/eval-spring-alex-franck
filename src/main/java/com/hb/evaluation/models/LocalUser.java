package com.hb.evaluation.models;

import java.util.List;

public class LocalUser {

	private Integer id;
	private String username;
	private String password;
	private String role;
	private List<String> categories;

	public LocalUser() {

	}

	public LocalUser(Integer id, String username, String password, String role) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public LocalUser(Integer id, String username, String password, String role, List<String> categories) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
