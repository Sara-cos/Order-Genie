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

const customerUsername = document.querySelector("#customerid-or-name");
const customerPassword = document.querySelector("#customer-password");
console.log(customerUsername)
console.log(customerPassword)
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
