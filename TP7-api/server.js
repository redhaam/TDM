var express = require("express");
var mysql = require("mysql");
var app = express();

// par défaut le mot de passe est ''
var connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : '',
    database:'userdb'
});
connection.connect();

app.use(express.json())

app.get('/getmovies',function(req,res){  
    var query = "select * from userdb.movies";
    connection.query(query,function(error,results){
    if (error) { throw(error) }
    res.send(JSON.stringify(results));
})

});

app.get('/getmovieactors/:title',function(req,res){  
    var query = "select id_Actor as id,firstName,lastName,gender from actors,cast,movies where title=?";
    connection.query(query,[req.params.title],function(error,results){
    if (error) { throw(error) }
    res.send(JSON.stringify(results));
})

});
app.post('/addactor',function(req,res){  
    
    var query = "insert into actors(firstName,lastName,gender) values (?)";
    console.log(req.body)
    var actor = [req.body.firstName,req.body.lastName,req.body.gender]
    connection.query(query,[actor],function(error,results){
    if (error) { throw(error)} else { res.status(200).send("acteur inseré avec succès")}

});
    
    
});










var server = app.listen(8082,function(){
    var host = server.address().address
    var port = server.address().port
});


