// Simulated JSON data for employee details
const data = {
    "1001": {
        "Employee_Name": "Jaden Smith",
        "Company_ID": "DEF234",
        "Company_Name": "Acme Corporation",
        "LastLoggedIn" : ["2-09-2023,13:00","5-09-2023,16:40","10-08-2023,15:40"]
    },
    "1002": {
        "Employee_Name": "June Roy",
        "Company_ID": "DEF237",
        "Company_Name": "Widget Co.",
        "LastLoggedIn" : ["2-09-2023,13:00","5-09-2023,16:40"]
    },
    "1003": {
        "Employee_Name": "Alice Johnson",
        "Company_ID": "DEF789",
        "Company_Name": "Tech Solutions Inc.",
        "LastLoggedIn" : ["2-09-2023,13:00","5-09-2023,16:40"]
    }
}


// Attach event listeners to buttons
document.getElementById('new-quote').addEventListener('click', function() {
    alert('New Quote button clicked.');
});

// document.getElementById('import-product').addEventListener('click', function() {
//     alert('Import Product button clicked.');
// });



// Importing data file
const importProductsButton = document.getElementById('import-product');
const fileInput = document.getElementById('fileInput');

importProductsButton.addEventListener('click', () => {
    fileInput.click();
});

fileInput.addEventListener('change', () => {
    const selectedFile = fileInput.files[0];
    
    if (selectedFile) {
        const reader = new FileReader();
        
        reader.onload = (event) => {
            const fileContents = event.target.result;
            try {
                const jsonData = JSON.parse(fileContents);
                // jsonData now contains the parsed JSON data
                console.log('JSON Data:', jsonData);
                
                // You can perform actions with the JSON data here
            } catch (error) {
                console.error('Error parsing JSON:', error);
                // Handle parsing errors here
            }
        };
        
        reader.readAsText(selectedFile);
    }
});


// const urlParams = new URLSearchParams(window.location.search);
// const empId = urlParams.get('empId');
// const employeeId = '1002'; // Authenticated ID parsed here ######
// const employeeData = data[employeeId];
// console.log(employeeData)
//         if (employeeData) {
//             // Display individual employee details
//             document.getElementById('employee-name').textContent = employeeData.Employee_Name;
//             document.getElementById('company-id').textContent = employeeData.Company_ID;
//             document.getElementById('company-name').textContent = employeeData.Company_Name;
//             // document.getElementById('last-logged').textContent = employeeData.lastLoggedIn;
//             document.getElementById('employee-id').textContent = "1001";
            
//             const lastLoggedInList = document.getElementById('last-logged');
//             for (const timestamp of employeeData.LastLoggedIn) {
//                 const listItem = document.createElement('li');
//                 listItem.textContent = timestamp;
//                 lastLoggedInList.appendChild(listItem);
//             }
//         } else {
//             alert('Employee not found.');
//         }



// Employee Details Fetched from JSON Data-file
fetch('src/json/employees_details.json')
    .then(response => response.json())
    .then(data => {

        const employeeId = '1002';
        const employeeData = data[employeeId];
        console.log(employeeData)
        // const { employeeId, company, lastLoggedIn, name } = data;

        // Display employee details individually
        if (employeeData) {
            // Display individual employee details
            document.getElementById('employee-name').textContent = employeeData.Employee_Name;
            document.getElementById('company-id').textContent = employeeData.Company_ID;
            document.getElementById('company-name').textContent = employeeData.Company_Name;
            document.getElementById('last-logged').textContent = employeeData.lastLoggedIn;
        } else {
            // Employee not found
            alert('Employee not found.');
        }
    })
    .catch(error => {
        console.error('Error fetching employee details:', error);
    });






