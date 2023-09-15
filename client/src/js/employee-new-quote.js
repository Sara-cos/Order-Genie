document.getElementById("customerName").addEventListener("input", function () {
  const customerName = this.value;

  fetch("customerData.json")
    .then((response) => response.json())
    .then((data) => {
      const customer = data[customerName];
      if (customer) {
        // Populate the form fields with data from the JSON object
        document.getElementById("orderDate").value = customer.orderDate;
        document.getElementById("customerGST").value = customer.customerGST;
        document.getElementById("shippingAddress").value =
          customer.shippingAddress;
        document.getElementById("customerCity").value = customer.customerCity;
        document.getElementById("customerPhone").value = customer.customerPhone;
        document.getElementById("customerEmail").value = customer.customerEmail;
        document.getElementById("customerPin").value = customer.customerPin;
        document.getElementById("shippingCost").value = customer.shippingCost;
        document.getElementById("totalOrderValue").value =
          customer.totalOrderValue;
      } else {
        // Clear the form fields if customer data is not found
        document.getElementById("orderDate").value = "";
        document.getElementById("customerGST").value = "";
        document.getElementById("shippingAddress").value = "";
        document.getElementById("customerCity").value = "";
        document.getElementById("customerPhone").value = "";
        document.getElementById("customerEmail").value = "";
        document.getElementById("customerPin").value = "";
        document.getElementById("shippingCost").value = "";
        document.getElementById("totalOrderValue").value = "";
      }
    })
    .catch((error) => console.log("Error:", error));
});

document
  .getElementById("quoteForm")
  .addEventListener("submit", function (event) {
    event.preventDefault();
  });

  document
  .getElementById("quote-submit-button")
  .addEventListener("submit", function (event) {
    event.preventDefault();
    this.onclick(window.location.href('../../html/pages/shop.html'));
  });