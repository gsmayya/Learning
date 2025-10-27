const mongoose = require("mongoose")
const url = "mongodb://localhost:27017/courses"
mongoose.connect(url, { useNewUrlParser: true })

const database = mongoose.connection
console.log(database)
database.once("open", (_) => {
	console.log("Connected to database : ", url)
})

database.on("error", (error) => {
	console.log("Error ", error)
})
