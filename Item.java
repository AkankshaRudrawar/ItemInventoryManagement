package com.iteminventorymanagement.example.ItemInventoryManagement;

//import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String sku;
	private double purchaseCost;
	private double sellingPrice;
	private double margin;
	private double taxPercentage;
	private double averageInventoryPrice;
	private double availableCost;
	private Date lastDate;


	public Item(long id, String name, String sku, double purchaseCost, double sellingPrice, double margin,
			double taxPercentage, double averageInventoryPrice, double availableCost, Date lastDate) {
		super();
		this.id = id;
		this.name = name;
		this.sku = sku;
		this.purchaseCost = purchaseCost;
		this.sellingPrice = sellingPrice;
		this.margin = margin;
		this.taxPercentage = taxPercentage;
		this.averageInventoryPrice = averageInventoryPrice;
		this.availableCost = availableCost;
		this.lastDate = lastDate;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public double getPurchaseCost() {
		return purchaseCost;
	}


	public void setPurchaseCost(double purchaseCost) {
		this.purchaseCost = purchaseCost;
	}


	public double getSellingPrice() {
		return sellingPrice;
	}


	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}


	public double getMargin() {
		return margin;
	}


	public void setMargin(double margin) {
		this.margin = margin;
	}


	public double getTaxPercentage() {
		return taxPercentage;
	}


	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}


	public double getAverageInventoryPrice() {
		return averageInventoryPrice;
	}


	public void setAverageInventoryPrice(double averageInventoryPrice) {
		this.averageInventoryPrice = averageInventoryPrice;
	}


	public double getAvailableCost() {
		return availableCost;
	}


	public void setAvailableCost(double availableCost) {
		this.availableCost = availableCost;
	}


	public Date getLastDate() {
		return lastDate;
	}


	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
}

