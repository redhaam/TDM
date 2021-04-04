let database = require('../DB');
let { generateAccessToken } = require('./index');
let router = require('express').Router();

router.post('/login', function (req, res) {
	let query =
		'select * from users where users.email = ? and users.password = ?';
	let userInfo = req.body;
	database.query(
		query,
		[userInfo.email, userInfo.password],
		function (error, result) {
			let response = {};
			if (result.length) {
				var dbResponse = { ...result[0] };
				response.authToken = generateAccessToken(dbResponse.id);
			} else {
			}
			res.send(JSON.stringify(response));
		}
	);
});

module.exports = router;
