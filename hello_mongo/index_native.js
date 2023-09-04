const MongoClient = require("mongodb").MongoClient
const url = "mongodb://localhost:27017"
const databaseName = "courses"

let database

MongoClient.connect(url, { useNewUrlParser: true }, (error, client) => {
	if (error) return console.log(error)
	database = client.db(databaseName)
	console.log(`database: ${databaseName}`)
	console.log(`connected mongodb: ${url}`)
})
