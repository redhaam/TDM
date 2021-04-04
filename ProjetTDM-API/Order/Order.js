let Client = require('./Client');

module.exports = function (
	orderId,
	name,
	orderStatus,
	orderAdress,
	cost,
	client
) {
	return {
		num: orderId,
		name,
		status: orderStatus,
		client,
		deliveryAdress: orderAdress,
		cost,
		productsList: []
	};
};
