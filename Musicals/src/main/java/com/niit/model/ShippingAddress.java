package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShippingAddress {
	
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String apartmentnumber;
	private String streetname;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the apartmentnumber
	 */
	public String getApartmentnumber() {
		return apartmentnumber;
	}
	/**
	 * @param apartmentnumber the apartmentnumber to set
	 */
	public void setApartmentnumber(String apartmentnumber) {
		this.apartmentnumber = apartmentnumber;
	}
	/**
	 * @return the streetname
	 */
	public String getStreetname() {
		return streetname;
	}
	/**
	 * @param streetname the streetname to set
	 */
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
