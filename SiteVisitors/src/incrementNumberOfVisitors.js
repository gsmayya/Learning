const express = require("express")
const mongoose = require("mongoose")
const siteVisitors = require("../models/siteVisitors")

const siteVisitorsId = "64ecf98743c5b6d496363d00"
incrementNumberOfVisitors = function () {
	siteVisitors
		.findByIdAndUpdate(
			siteVisitorsId,
			{
				$inc: { numberOfSiteVisitors: 1 },
			},
			{ new: true }
		)
		.then((data) => {
			console.log(data.numberOfSiteVisitors)
		})
		.catch((error) => {
			console.log(error)
		})
}

module.exports = { incrementNumberOfVisitors }
