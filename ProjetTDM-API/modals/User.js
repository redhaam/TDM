module.exports.User = function (idUser, email, ordersList = []) {
	return {
		idUser: idUser,
		email: email,
		ordersList: ordersList
	};
};
