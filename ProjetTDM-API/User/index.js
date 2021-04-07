let { authenticateToken } = require('../Auth');
let database = require('../DB');
let router = require('express').Router();
let User = require('./User');

router.get('/', authenticateToken, function (req, res) {
	let query =
		'SELECT id, name,order_status, count(id_order) as count FROM users, orders group by order_status;';
	database.query(query, req.userId, function (err, result) {
		if (!err) {
			let userInfo = { ...result[0] };
			let count = {};
			[...result].reduce(
				(c, row) => (c[row.order_status] = row.count),
				count
			);

			let user = User(userInfo.id, userInfo.name, count);
			res.send(JSON.stringify(user));
		}
	});
});

module.exports = router;
