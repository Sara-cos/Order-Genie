document.addEventListener('DOMContentLoaded', () => {
    const quoteList = document.getElementById('quote-list');
    const orderList = document.getElementById('order-list');
    const detailsContainer = document.getElementById('details-container');
    const invoiceModal = document.getElementById('invoice-modal');
    const invoiceContent = document.getElementById('invoice-content');

    // Sample data (replace with your actual data or fetch from the backend)
    const quotes = [
        { id: 1, date: '2023-08-01', shippingCost: 10, totalValue: 100, status: 'pending' },
        { id: 2, date: '2023-08-05', shippingCost: 15, totalValue: 120, status: 'pending' },
        // Add more quotes here
    ];

    const orders = [
        { id: 101, date: '2023-08-15', shippingCost: 15, totalValue: 200, status: 'approved' },
        { id: 102, date: '2023-08-20', shippingCost: 20, totalValue: 250, status: 'completed' },
        { id: 103, date: '2023-08-25', shippingCost: 12, totalValue: 150, status: 'completed' },
        // Add more orders here
    ];

    // Function to display quotes in the list
    function displayQuotes() {
        quoteList.innerHTML = '';
        quotes.forEach((quote) => {
            const listItem = createListItem(quote, 'quote');
            quoteList.appendChild(listItem);
        });
    }

    // Function to display orders in the list
    function displayOrders() {
        orderList.innerHTML = '';
        orders.forEach((order) => {
            const listItem = createListItem(order, 'order');
            orderList.appendChild(listItem);
        });
    }

    // Function to create list items for quotes and orders
    function createListItem(item, type) {
        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <span>ID: ${item.id}</span>
            <span>Date: ${item.date}</span>
            <span>Shipping Cost: $${item.shippingCost}</span>
            <span>Total Value: $${item.totalValue}</span>
            <span>Status: ${item.status}</span>
        `;

        if (type === 'quote') {
            const approveButton = document.createElement('button');
            approveButton.textContent = 'Approve';
            approveButton.addEventListener('click', () => {
                if (confirm('Are you sure you want to approve this quote?')) {
                    approveQuote(item);
                }
            });
            listItem.appendChild(approveButton);
        } else if (type === 'order' && item.status !== 'approved' && !isSameDay(item.date)) {
            const showInvoiceButton = document.createElement('button');
            showInvoiceButton.textContent = 'Show Invoice';
            showInvoiceButton.addEventListener('click', () => {
                showInvoice(item);
            });
            listItem.appendChild(showInvoiceButton);
        }

        listItem.addEventListener('click', () => {
            showDetails(item, type);
        });

        return listItem;
    }

    // Function to approve a quote
    function approveQuote(quote) {
        if (!quote.id || !quote.date || !quote.shippingCost || !quote.totalValue) {
            alert('All fields are required for approval.');
            return;
        }

        const currentDate = new Date();
        const orderDate = new Date(quote.date);

        if (currentDate - orderDate > 30 * 24 * 60 * 60 * 1000) {
            quote.status = 'expired';
        } else {
            quote.status = 'approved';
        }

        displayQuotes();
    }

    // Function to show invoice
    function showInvoice(order) {
        if (isSameDay(order.date)) {
            alert('Invoice not available for orders approved on the same day.');
            return;
        }

        // Simulate invoice data (replace with actual invoice data)
        const invoiceData = {
            orderID: order.id,
            customer: 'John Doe',
            items: [
                { description: 'Product A', quantity: 2, price: 50 },
                { description: 'Product B', quantity: 1, price: 30 },
                // Add more items as needed
            ],
            total: order.totalValue,
        };

        // Render the invoice content
        const invoiceHTML = `
            <h2>Invoice for Order #${invoiceData.orderID}</h2>
            <p>Customer: ${invoiceData.customer}</p>
            <table>
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    ${invoiceData.items
                        .map(
                            (item) => `
                                <tr>
                                    <td>${item.description}</td>
                                    <td>${item.quantity}</td>
                                    <td>$${item.price}</td>
                                    <td>$${item.quantity * item.price}</td>
                                </tr>
                            `
                        )
                        .join('')}
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="3">Total</td>
                        <td>$${invoiceData.total}</td>
                    </tr>
                </tfoot>
            </table>
        `;

        invoiceContent.innerHTML = invoiceHTML;
        invoiceModal.style.display = 'block';
    }

    // Function to display details of a quote or order
    function showDetails(item, type) {
        detailsContainer.innerHTML = `
            <h3>${type.charAt(0).toUpperCase() + type.slice(1)} Details</h3>
            <pre>${JSON.stringify(item, null, 2)}</pre>
        `;
    }

    // Function to check if two dates are the same day
    function isSameDay(dateString) {
        const today = new Date();
        const otherDate = new Date(dateString);
        return (
            today.getFullYear() === otherDate.getFullYear() &&
            today.getMonth() === otherDate.getMonth() &&
            today.getDate() === otherDate.getDate()
        );
    }

    // Event listener for closing the invoice modal
    document.getElementById('close-invoice-modal').addEventListener('click', closeInvoiceModal);

    // Function to close the invoice modal
    function closeInvoiceModal() {
        invoiceModal.style.display = 'none';
    }

    // Initial data rendering
    displayQuotes();
    displayOrders();
});
