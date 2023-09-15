/* import data from "../json/quotes.json" assert { type: "json" };
const dummyData = data; */

const dummyData = {
  "quotes": [
    {
      "quoteId": "Q1001",
      "quoteAmount": 35000.5,
      "quoteStatus": "Complete",
      "customerName": "Rajesh Kumar",
      "customerCity": "Delhi",
      "orderDate": "2023-09-15"
    },
    {
      "quoteId": "Q1002",
      "quoteAmount": 55000.75,
      "quoteStatus": "Pending",
      "customerName": "Sneha Sharma",
      "customerCity": "Mumbai",
      "orderDate": "2023-09-16"
    },
    {
      "quoteId": "Q1003",
      "quoteAmount": 78000.25,
      "quoteStatus": "Expired",
      "customerName": "Amit Patel",
      "customerCity": "Ahmedabad",
      "orderDate": "2023-09-17"
    },
    {
      "quoteId": "Q1004",
      "quoteAmount": 42000.3,
      "quoteStatus": "Pending",
      "customerName": "Neha Singh",
      "customerCity": "Bangalore",
      "orderDate": "2023-09-18"
    },
    {
      "quoteId": "Q1005",
      "quoteAmount": 68000.95,
      "quoteStatus": "Complete",
      "customerName": "Sanjay Verma",
      "customerCity": "Chennai",
      "orderDate": "2023-09-19"
    },
    {
      "quoteId": "Q1006",
      "quoteAmount": 60000.0,
      "quoteStatus": "Complete",
      "customerName": "Priya Gupta",
      "customerCity": "Kolkata",
      "orderDate": "2023-09-20"
    },
    {
      "quoteId": "Q1007",
      "quoteAmount": 32000.8,
      "quoteStatus": "Pending",
      "customerName": "Sachin Singh",
      "customerCity": "Pune",
      "orderDate": "2023-09-21"
    },
    {
      "quoteId": "Q1008",
      "quoteAmount": 95000.2,
      "quoteStatus": "Expired",
      "customerName": "Rita Verma",
      "customerCity": "Jaipur",
      "orderDate": "2023-09-22"
    },
    {
      "quoteId": "Q1009",
      "quoteAmount": 55000.6,
      "quoteStatus": "Complete",
      "customerName": "Kunal Kapoor",
      "customerCity": "Hyderabad",
      "orderDate": "2023-09-23"
    },
    {
      "quoteId": "Q1010",
      "quoteAmount": 72000.4,
      "quoteStatus": "Pending",
      "customerName": "Nisha Reddy",
      "customerCity": "Bengaluru",
      "orderDate": "2023-09-24"
    }
  ]
}

function createQuoteCard(quote) {
  // Create the quote card container
  const quoteCard = document.createElement("div");
  quoteCard.classList.add("quote-card");

  // Create the order ID section
  const orderIdSection = document.createElement("div");
  orderIdSection.classList.add("order-id");
  orderIdSection.innerHTML = `
    <i class="bi bi-file-earmark-text"></i>
    <p>${quote.quoteId}</p>
  `;

  // Create the order amount section
  const orderAmountSection = document.createElement("div");
  orderAmountSection.classList.add("order-amount");
  orderAmountSection.innerHTML = `
    <i class="bi bi-cash"></i>
    <p>INR ${quote.quoteAmount.toFixed(2)}</p>
  `;

  // Create the order status section
  const orderStatusSection = document.createElement("div");
  orderStatusSection.classList.add("order-status");
  orderStatusSection.innerHTML = `
    <div class="order-status-circle"></div>
    <span>${quote.quoteStatus}</span>
  `;

  // Create the order info section
  const orderInfoSection = document.createElement("div");
  orderInfoSection.classList.add("order-info");
  orderInfoSection.innerHTML = `
    <div class="order-image">
      <img
        src="../../assets/images/delivery-box.png"
        height="100px"
        width="100px"
        alt=""
      />
    </div>
    <div class="order-details">
      <div class="customer-name">
        <i class="bi bi-person"></i>
        <p>${quote.customerName}</p>
      </div>
      <div class="customer-city">
        <i class="bi bi-geo-alt"></i>
        <p>${quote.customerCity}</p>
      </div>
      <div class="order-date">
        <i class="bi bi-calendar"></i>
        <p>${quote.orderDate}</p>
      </div>
    </div>
  `;

  // Append sections to the quote card
  quoteCard.appendChild(orderIdSection);
  quoteCard.appendChild(orderAmountSection);
  quoteCard.appendChild(orderStatusSection);
  quoteCard.appendChild(orderInfoSection);

  return quoteCard;
}

// Function to render quote cards from JSON data
function renderQuoteCards(data) {
  const quotesList = document.querySelector(".quotes-list");

  data.quotes.forEach((quote) => {
    const quoteCard = createQuoteCard(quote);
    quotesList.appendChild(quoteCard);
  });
}

// Render quote cards from the dummy data
renderQuoteCards(dummyData);
