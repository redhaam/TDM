let database = require('../DB');
let { authenticateToken } = require('../Auth');
let Order = require('./Order');
const Client = require('./Client');
const Adress = require('./Adress');

let router = require('express').Router();

/* GET /orders
return Order[]
*/
router.get('/', authenticateToken, function (req, res) {
	let query =
		'select id_order, order_name, order_status, cost, client as id_client, client_name, email, phone_number, id_adress,longtitude, latitude, street_name  from orders, clients, adresses where orders.id_deliverer = ? and orders.order_adress = adresses.id_adress;';
	database.query(query, req.userId, function (error, result) {
		let orders = [...result];
		orders = orders.map(order =>
			Order(
				order.id_order,
				order.order_name,
				order.order_status,
				Adress(order.street_name, order.longtitude, order.latitude),
				order.cost,
				Client(order.id_client, order.email, order.phone_number)
			)
		);
		res.send(JSON.stringify(orders));
	});
});


module.exports = router;
