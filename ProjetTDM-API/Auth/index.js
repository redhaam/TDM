require('dotenv').config();
const jwt = require('jsonwebtoken');

let login = require('./login');

module.exports.generateAccessToken = function (username) {
	return jwt.sign(username, process.env.TOKEN_SECRET);
};

module.exports.authenticateToken = function (req, res, next) {
	const authHeader = req.headers['authorization'];
	const token = authHeader && authHeader.split(' ')[1];

	if (token == null) return res.sendStatus(401);

	jwt.verify(token, process.env.TOKEN_SECRET, (err, userId) => {
		if (err) return res.sendStatus(403);

		req.userId = userId;

		next();
	});
};

module.exports.login = login;
