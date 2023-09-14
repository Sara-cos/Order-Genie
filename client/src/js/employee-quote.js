import quotes from "../json/quotes.json" assert { type: "json" };
const dummyData = quotes;

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
