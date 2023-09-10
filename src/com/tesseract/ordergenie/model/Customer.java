package com.CodeFury.ui;

import java.util.Objects;

public class Customer {
	 private int customer;
	 private String customerName;
	 private String customerGstNumber;
	 private String customerAddress;
	 private String CustomerCity;
	 private String email;
	 private long phone;
	 private int pincode;
   boolean customerLoginStatus;
public int getCustomer() {
	return customer;
}
public void setCustomer(int customer) {
	this.customer = customer;
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
	return "Customer [customer=" + customer + ", customerName=" + customerName + ", customerGstNumber="
			+ customerGstNumber + ", customerAddress=" + customerAddress + ", CustomerCity=" + CustomerCity + ", email="
			+ email + ", phone=" + phone + ", pincode=" + pincode + ", customerLoginStatus=" + customerLoginStatus
			+ "]";
}
@Override
public int hashCode() {
	return Objects.hash(CustomerCity, customer, customerAddress, customerGstNumber, customerLoginStatus, customerName,
			email, phone, pincode);
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
	return Objects.equals(CustomerCity, other.CustomerCity) && customer == other.customer
			&& Objects.equals(customerAddress, other.customerAddress)
			&& Objects.equals(customerGstNumber, other.customerGstNumber)
			&& customerLoginStatus == other.customerLoginStatus && Objects.equals(customerName, other.customerName)
			&& Objects.equals(email, other.email) && phone == other.phone && pincode == other.pincode;
}
public Customer(int customer, String customerName, String customerGstNumber, String customerAddress,
		String customerCity, String email, long phone, int pincode, boolean customerLoginStatus) {
	super();
	this.customer = customer;
	this.customerName = customerName;
	this.customerGstNumber = customerGstNumber;
	this.customerAddress = customerAddress;
	CustomerCity = customerCity;
	this.email = email;
	this.phone = phone;
	this.pincode = pincode;
	this.customerLoginStatus = customerLoginStatus;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}

}
