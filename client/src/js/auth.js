// general employee-details json
const users = [
  {
    "employeeId": 1001,
    "username": "employee1",
    "password": "password1",
    "employeeLoginStatus": false
  },
  {
    "employeeId": 1002,
    "username": "employee2",
    "password": "password2",
    "employeeLoginStatus": false
  },
  {
    "employeeId": 1003,
    "username": "employee3",
    "password": "password3",
    "employeeLoginStatus": false
  },
  {
    "employeeId": 1004,
    "username": "employee4",
    "password": "password4",
    "employeeLoginStatus": false
  },
  {
    "employeeId": 1005,
    "username": "employee5",
    "password": "password5",
    "employeeLoginStatus": false
  }
]

// General customer json
const customers = [
  {
    "customer_id": "CUST001",
    "customer_name": "Rahul Sharma",
    "customer_GST_no": "GSTIN1234AB",
    "customer_shipping_address": "45 Gandhi Road",
    "city": "Mumbai",
    "pincode": "400001",
    "phone_number": "+91 9876543210",
    "email": "rahul.sharma@example.com",
    "password":"password1"
  },
  {
    "customer_id": "CUST002",
    "customer_name": "Priya Patel",
    "customer_GST_no": "GSTIN5678CD",
    "customer_shipping_address": "32 Rajpur Lane",
    "city": "Delhi",
    "pincode": "110001",
    "phone_number": "+91 8765432109",
    "email": "priya.patel@example.com",
    "password":"password2"
  },
  {
    "customer_id": "CUST003",
    "customer_name": "Amit Gupta",
    "customer_GST_no": "GSTIN9876EF",
    "customer_shipping_address": "72 Nehru Street",
    "city": "Bangalore",
    "pincode": "560001",
    "phone_number": "+91 7890123456",
    "email": "amit.gupta@example.com",
    "password":"password3"
  },
  {
    "customer_id": "CUST004",
    "customer_name": "Anjali Verma",
    "customer_GST_no": "GSTIN5432GH",
    "customer_shipping_address": "28 Shastri Nagar",
    "city": "Kolkata",
    "pincode": "700001",
    "phone_number": "+91 9876541230",
    "email": "anjali.verma@example.com",
    "password":"password4"
  },
  {
    "customer_id": "CUST005",
    "customer_name": "Neha Singh",
    "customer_GST_no": "GSTIN7890IJ",
    "customer_shipping_address": "15 Sardar Lane",
    "city": "Chennai",
    "pincode": "600001",
    "phone_number": "+91 8765432101",
    "email": "neha.singh@example.com",
    "password":"password5"
  },
  {
    "customer_id": "CUST006",
    "customer_name": "Rajesh Kumar",
    "customer_GST_no": "GSTIN2345KL",
    "customer_shipping_address": "56 Patel Nagar",
    "city": "Hyderabad",
    "pincode": "500001",
    "phone_number": "+91 7890123456",
    "email": "rajesh.kumar@example.com",
    "password":"password6"
  }
]


// JavaScript code to show/hide forms
const customerForm = document.querySelector('#customer-form');
const employeeForm = document.querySelector('#employee-form');
const authTypeButton = document.getElementById('auth-type-button-holder');

function customerLogin() {
  customerForm.style.display = 'block';
  employeeForm.style.display = 'none';
  authTypeButton.style.left = '0';
}

function employeeLogin() {
  customerForm.style.display = 'none';
  employeeForm.style.display = 'block';
  authTypeButton.style.left = '50%';
}

customerLogin();

// JavaScript code to validate customer and employee logins
employeeForm.addEventListener('submit', function (e) {
  e.preventDefault();

  const usernameInput = document.getElementById('empid').value;
  const passwordInput = document.getElementById('employee-password').value;

  // Check if the provided credentials match any user
  const user = users.find(u => (u.username === usernameInput || u.employeeId.toString() === usernameInput) && u.password === passwordInput);
  if (user) {
      // Successful login, redirects
      const empId = user.employeeId;
      window.location.href = `../pages/employee-homepage.html?empId=${empId}`;
  } else {
      errorMessage.textContent = 'Invalid username or password. Please try again.';
  }
});


customerForm.addEventListener('submit', function (e) {
  e.preventDefault();

  const usernameInput = document.getElementById('customerid-or-name').value;
  const passwordInput = document.getElementById('customer-password').value;

  // Check if the provided credentials match any user
  const customer = customers.find(c => (c.customer_name === usernameInput || c.customer_id === usernameInput) && c.password === passwordInput);
  if (customer) {
      // Successful login, redirects
      const customerId = customer.customer_id;
      window.location.href = `../pages/shop.html?customerId=${customerId}`;
  } else {
      errorMessage.textContent = 'Invalid username or password. Please try again.';
  }
});

const notification = document.querySelector('.notification');

customerForm.addEventListener("submit", onSubmit);

function onSubmit(e) {
  e.preventDefault();
  if (customerUsername.value === "" || customerPassword.value === "") {
    // alert("Please enter all fields!");
    notification.classList.add("error-notification");
    notification.innerHTML = "Please enter all fields!";
    notification.style.display = "block"; // Show the message
    setTimeout(() => {
      notification.style.display = "none"; // Hide the msg div
    }, 3000);
  } else {
    notification.classList.add("success-notification");
    notification.innerHTML = "Validation successful!";
    notification.style.display = "block"; // Show the message
    setTimeout(() => {
      notification.style.display = "none"; // Hide the msg div
    }, 3000);
    // alert("Registration successful!");

    // Clear fields
    customerUsername.value = "";
    customerPassword.value = "";
  }
}
