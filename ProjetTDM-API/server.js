var express = require('express');
var ordersRoutes = require('./Order');
var authRoutes = require('./Auth').login;
var app = express();
app.use(express.json());

app.get('/', function (req, res) {
	res.sendStatus(200);
});

app.use('/orders', ordersRoutes);

app.use('/', authRoutes);

var server = app.listen(5000, function () {
	console.log(`listening on port : ${server.address().port}`);
});
