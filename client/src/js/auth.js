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
  console.log(usernameInput)
  console.log(passwordInput)

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

  // const usernameInput = document.getElementById('cus').value;
  const passwordInput = document.getElementById('employee-password').value;
  console.log(usernameInput)
  console.log(passwordInput)

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


// console.log(customerUsername)
// console.log(customerPassword)
// const notification = document.querySelector('.notification');

// customerForm.addEventListener("submit", onSubmit);

// function onSubmit(e) {
//   e.preventDefault();
//   if (customerUsername.value === "" || customerPassword.value === "") {
//     // alert("Please enter all fields!");
//     notification.classList.add("error-notification");
//     notification.innerHTML = "Please enter all fields!";
//     notification.style.display = "block"; // Show the message
//     setTimeout(() => {
//       notification.style.display = "none"; // Hide the msg div
//     }, 3000);
//   } else {
//     notification.classList.add("success-notification");
//     notification.innerHTML = "Validation successful!";
//     notification.style.display = "block"; // Show the message
//     setTimeout(() => {
//       notification.style.display = "none"; // Hide the msg div
//     }, 3000);
//     // alert("Registration successful!");

//     // Clear fields
//     customerUsername.value = "";
//     customerPassword.value = "";
//   }
// }
