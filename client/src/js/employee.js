// Simulated JSON data for employee details
const employeeData = {
    employeeId: 'EMP12345',
    company: 'ACME Corporation',
    lastLoggedIn: 'September 10, 2023, 10:30 AM',
};

// Attach event listeners to buttons
document.getElementById('new-quote').addEventListener('click', function() {
    alert('New Quote button clicked.');
});

// document.getElementById('import-product').addEventListener('click', function() {
//     alert('Import Product button clicked.');
// });

// Display employee details
document.querySelector('.employee-name').textContent = 'John Doe'; // Replace with actual employee name
document.querySelector('.employee-details').innerHTML = `
    <p><strong>Employee ID:</strong> ${employeeData.employeeId}</p>
    <p><strong>Company:</strong> ${employeeData.company}</p>
    <p><strong>Last Logged In:</strong> ${employeeData.lastLoggedIn}</p>
`;



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


// Employee Details Fetched from JSON Data-file
function fetchEmployeeDetails() {
    fetch('employee.json') // Replace with the path to your JSON file
        .then(response => response.json())
        .then(data => {
            const employeeList = document.getElementById('employeeList');
            employeeList.innerHTML = ''; // Clear any previous content

            data.forEach(employee => {
                const employeeDiv = document.createElement('div');
                employeeDiv.innerHTML = `
                    <h2>${employee.name}</h2>
                    <p>ID: ${employee.id}</p>
                    <p>Position: ${employee.position}</p>
                    <p>Email: <a href="mailto:${employee.email}">${employee.email}</a></p>
                    <hr>
                `;
                employeeList.appendChild(employeeDiv);
            });
        })
        .catch(error => {
            console.error('Error fetching employee data:', error);
        });
}
