package com.CodeFury.ui;

import java.util.Objects;

public class Company {
      private String companyName;
      private String companyAddress;
      private String companyCity;
      private String companyGstNumber;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyCity() {
		return companyCity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(companyAddress, companyCity, companyGstNumber, companyName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(companyAddress, other.companyAddress) && Objects.equals(companyCity, other.companyCity)
				&& Objects.equals(companyGstNumber, other.companyGstNumber)
				&& Objects.equals(companyName, other.companyName);
	}
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyAddress=" + companyAddress + ", companyCity="
				+ companyCity + ", companyGstNumber=" + companyGstNumber + "]";
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(String companyName, String companyAddress, String companyCity, String companyGstNumber) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyCity = companyCity;
		this.companyGstNumber = companyGstNumber;
	}
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	public String getCompanyGstNumber() {
		return companyGstNumber;
	}
	public void setCompanyGstNumber(String companyGstNumber) {
		this.companyGstNumber = companyGstNumber;
	}
}
