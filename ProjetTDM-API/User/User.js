module.exports = function (idUser, email, count) {
	return {
		idUser: idUser,
		email: email,
		ordersList: [],
		ongoingOrdersCount: count['ongoing'] || 0,
		deliveredOrdersCount: count['delivered'] || 0,
		lateOrdersCount: count['late'] || 0
	};
};
