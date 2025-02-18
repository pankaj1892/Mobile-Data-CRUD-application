package com.entity;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mobiles")
public class Mobile {
	@Id
	private String modelNo;
	private String name;
	private double price;
	private LocalDate launchDate;

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getModelNo() {
		return modelNo;
	}

	public Mobile(String modelNo, String name, double price, LocalDate launchDate) {
		super();
		this.modelNo = modelNo;
		this.name = name;
		this.price = price;
		this.launchDate = launchDate;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {
		this.launchDate = launchDate;
	}

	@Override
	public String toString() {
		return "Mobile [modelNo=" + modelNo + ", name=" + name + ", price=" + price + ", launchDate=" + launchDate
				+ "]";
	}

}