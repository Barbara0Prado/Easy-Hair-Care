package model;

import java.io.Serializable;

public class Provider implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idProvider;
	private int location;
	private String name;
	private int star;
	
	public int getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}

}