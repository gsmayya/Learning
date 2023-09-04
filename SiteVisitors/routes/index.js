var express = require("express")
var router = express.Router()
const mongoose = require("mongoose")
const siteVisitors = require("../models/siteVisitors")
const incrementNumberOfVisitors = require("../src/incrementNumberOfVisitors")
const siteVisitorsId = "64ecf98743c5b6d496363d00"
/* GET home page. */
router.get("/", function (req, res, next) {
	incrementNumberOfVisitors.incrementNumberOfVisitors()
	siteVisitors
		.findById(siteVisitorsId)
		.then(
			(data) => {
				res.render("index", { title: data.numberOfSiteVisitors })
			},
			(error) => {
				next(error)
			}
		)
		.catch((error) => {
			next(error)
		})
})

module.exports = router
