var mysql = require('mysql');

require('dotenv').config();

let connectedToDb = false;

var connection = mysql.createConnection({
	host: 'localhost',
	user: process.env.user_name, // Configure you .env file
	password: process.env.user_password, // Configure you .env file
	database: process.env.db_name
});

if (!connectedToDb) {
	connection.connect(function (error) {
		if (error) console.log(error);
		connectedToDb = true;
	});
}

module.exports = connection;
