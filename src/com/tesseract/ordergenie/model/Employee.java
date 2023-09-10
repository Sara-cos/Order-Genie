package com.CodeFury.ui;

import java.util.Objects;

public class Employee {
	 private int employeeId;
	 private   String username;
	 private   String password;
	 private   boolean employeeLoginStatus;
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
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
		public boolean isEmployeeLoginStatus() {
			return employeeLoginStatus;
		}
		@Override
		public int hashCode() {
			return Objects.hash(employeeId, employeeLoginStatus, password, username);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return employeeId == other.employeeId && employeeLoginStatus == other.employeeLoginStatus
					&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
		}
		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", username=" + username + ", password=" + password
					+ ", employeeLoginStatus=" + employeeLoginStatus + "]";
		}
		public void setEmployeeLoginStatus(boolean employeeLoginStatus) {
			this.employeeLoginStatus = employeeLoginStatus;
		}
		public Employee(int employeeId, String username, String password, boolean employeeLoginStatus) {
			super();
			this.employeeId = employeeId;
			this.username = username;
			this.password = password;
			this.employeeLoginStatus = employeeLoginStatus;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
}
