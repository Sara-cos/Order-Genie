document.addEventListener("DOMContentLoaded", function () {
  // JSON data for products (sample data)
  const products = [
      {
          id: 1,
          name: "Product 1",
          price: 10.99,
          image: "product1.jpg"
      },
      {
          id: 2,
          name: "Product 2",
          price: 19.99,
          image: "product2.jpg"
      },
      // Add more product objects here...
  ];

  // Function to create a product card
  function createProductCard(product) {
      const card = document.createElement("div");
      card.classList.add("product-card");

      const image = document.createElement("img");
      image.src = product.image;
      image.alt = product.name;

      const name = document.createElement("h2");
      name.textContent = product.name;

      const price = document.createElement("p");
      price.textContent = `$${product.price.toFixed(2)}`;

      const actions = document.createElement("div");
      actions.classList.add("product-actions");

      const addButton = document.createElement("button");
      addButton.textContent = "+";

      const removeButton = document.createElement("button");
      removeButton.textContent = "-";

      actions.appendChild(removeButton);
      actions.appendChild(addButton);

      card.appendChild(image);
      card.appendChild(name);
      card.appendChild(price);
      card.appendChild(actions);

      // Event listeners for add and remove buttons (you can implement these)
      addButton.addEventListener("click", () => {
          // Implement add to cart logic here
      });

      removeButton.addEventListener("click", () => {
          // Implement remove from cart logic here
      });

      return card;
  }

  // Get the product container element
  const productContainer = document.getElementById("product-container");

  // Create product cards and add them to the product container
  products.forEach((product) => {
      const productCard = createProductCard(product);
      productContainer.appendChild(productCard);
  });
});
