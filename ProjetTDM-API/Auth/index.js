require('dotenv').config();
const jwt = require('jsonwebtoken');
let database = require('../DB');
let router = require('express').Router();

function generateAccessToken(username) {
	return jwt.sign(username, process.env.TOKEN_SECRET);
}

function authenticateToken(req, res, next) {
	const authHeader = req.headers['authorization'];
	const token = authHeader && authHeader.split(' ')[1];
	if (token == null) return res.sendStatus(401);

	jwt.verify(token, process.env.TOKEN_SECRET, (err, userId) => {
		if (err) return res.sendStatus(403);

		req.userId = userId;

		next();
	});
}

router.post('/', function (req, res) {
	let query =
		'select id from users where users.email = ? and users.password = ?';
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

module.exports = { router, generateAccessToken, authenticateToken };