var mysql = require('mysql');
var express = require('express');
var Auth = require('./auth');
var User = require('./modals/User').User;
require('dotenv').config();
var app = express();
app.use(express.json());

var connection = mysql.createConnection({
	host: 'localhost',
	user: process.env.user_name, // Configure you .env file
	password: process.env.user_password, // Configure you .env file
	database: process.env.db_name
});
connection.connect();

app.get('/', function (req, res) {
	res.sendStatus(200);
});

app.post('/login', function (req, res) {
	let query =
		'select * from users where users.email = ? and users.password = ?';
	let userInfo = req.body;
	connection.query(
		query,
		[userInfo.email, userInfo.password],
		function (error, result) {
			let response = {};
			if (result.length) {
				var dbResponse = { ...result[0] };
				response.authToken = Auth.generateAccessToken(dbResponse.id);
			} else {
			}
			res.send(JSON.stringify(response));
		}
	);
});

app.get('/getdeliveries', Auth.authenticateToken, function (req, res) {
	res.send(JSON.stringify({ id: 555 }));
});

var server = app.listen(5000, function () {
	console.log(`listening on port : ${server.address().port}`);
});
