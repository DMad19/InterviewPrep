let cart = ["shirts"];

function createOrder(cart) {
	return new Promise(function (resolve, reject) {
		if (cart.length > 0) {
			resolve(
				`orderId for the cart ${cart} is ${Math.floor(
					Math.random() * 100000
				)}`
			);
		} else {
			reject(new Error("Cart is Empty"));
		}
	});
}

function processPayment(orderId) {
	return new Promise(function (resolve, reject) {
		if (orderId) {
			resolve(`${orderId} Payment Processed`);
		} else {
			reject(new Error("Payment Failed"));
		}
	});
}

function summarizeOrder(orderSummary) {
	return new Promise(function (resolve, reject) {
		if (orderSummary) {
			resolve(`Order summary is ${orderSummary}`);
		} else {
			reject(new Error("Failed to fetch Order summary"));
		}
	});
}

function updateWallet(walletId) {
	return new Promise(function (resolve, reject) {
		if (walletId) {
			resolve(`${walletId} wallet updation Processed`);
		} else {
			reject("Wallet updation Failed");
		}
	});
}

createOrder(cart)
	.then((orderId) => {
		console.log(orderId);
		return orderId.split(" ").at(-1);
	})
	.catch((error) => console.log(error.message))
	.then((orderId) => processPayment(orderId))
	.then((paymentInfo) => {
		console.log(paymentInfo);
		return paymentInfo;
	})
	.catch((error) => console.log(error.message))
	.then((paymentInfo) => {
		return summarizeOrder(paymentInfo);
	})
	.then((summary) => {
		console.log(summary);
		return summary;
	})
	.then((summary) => updateWallet(summary))
	.then((walletUpdInfo) => console.log(walletUpdInfo))
	.catch((error) => console.log(error.message));
