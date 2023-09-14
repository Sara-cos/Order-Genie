package com.tesseract.ordergenie.model;

import java.util.List;
import java.util.Objects;

public class Customer {

	private int customerId;
	 private String customerName;
	 private String customerGstNumber;
	 private String customerAddress;
	 private String CustomerCity;
	 private String email;
	 private long phone;
	 private int pincode;
	 private String password;
	 private double totalAmountPaid;
	 public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	private List<Product> productList;
	 
  public double getTotalAmountPaid() {
		return totalAmountPaid;
	}
	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}
public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
boolean customerLoginStatus;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerGstNumber() {
	return customerGstNumber;
}
public void setCustomerGstNumber(String customerGstNumber) {
	this.customerGstNumber = customerGstNumber;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public String getCustomerCity() {
	return CustomerCity;
}
public void setCustomerCity(String customerCity) {
	CustomerCity = customerCity;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public boolean isCustomerLoginStatus() {
	return customerLoginStatus;
}
public void setCustomerLoginStatus(boolean customerLoginStatus) {
	this.customerLoginStatus = customerLoginStatus;
}
@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerGstNumber="
			+ customerGstNumber + ", customerAddress=" + customerAddress + ", CustomerCity=" + CustomerCity + ", email="
			+ email + ", phone=" + phone + ", pincode=" + pincode + ", customerLoginStatus=" + "customerLoginStatus= "
			+"totalAmountPaid= " +"]";
}
@Override
public int hashCode() {
	return Objects.hash(CustomerCity, customerId, customerAddress, customerGstNumber, customerLoginStatus, customerName,
			email, phone, pincode,totalAmountPaid);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Customer other = (Customer) obj;
	return Objects.equals(CustomerCity, other.CustomerCity) && customerId == other.customerId
			&& Objects.equals(customerAddress, other.customerAddress)
			&& Objects.equals(customerGstNumber, other.customerGstNumber)
			&& customerLoginStatus == other.customerLoginStatus && Objects.equals(customerName, other.customerName)
			&& Objects.equals(email, other.email) && phone == other.phone && pincode == other.pincode&& totalAmountPaid == other.totalAmountPaid;
}
public Customer(int customer, String customerName, String customerGstNumber, String customerAddress,
		String customerCity, String email, long phone, int pincode, boolean customerLoginStatus,double totalAmountPaid) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerGstNumber = customerGstNumber;
	this.customerAddress = customerAddress;
	CustomerCity = customerCity;
	this.email = email;
	this.phone = phone;
	this.pincode = pincode;
	this.customerLoginStatus = customerLoginStatus;
	this.totalAmountPaid=totalAmountPaid;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
}
