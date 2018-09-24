package com.niit.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int id;
	private String firstname;
	private String lastname;
	private String phonenumber;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;             //FK user_Email.
	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="billin_id")
	private BillingAddress billingaddress;  //billingaddress_id
	@OneToOne(cascade=CascadeType.ALL)
	private ShippingAddress shippingaddress; //shippingaddress_id
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the billingaddress
	 */
	public BillingAddress getBillingaddress() {
		return billingaddress;
	}
	/**
	 * @param billingaddress the billingaddress to set
	 */
	public void setBillingaddress(BillingAddress billingaddress) {
		this.billingaddress = billingaddress;
	}
	/**
	 * @return the shippingaddress
	 */
	public ShippingAddress getShippingaddress() {
		return shippingaddress;
	}
	/**
	 * @param shippingaddress the shippingaddress to set
	 */
	public void setShippingaddress(ShippingAddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
}
