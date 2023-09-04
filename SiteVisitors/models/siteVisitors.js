const mongoose = require("mongoose")

const schema = mongoose.Schema

const schemaOptions = {
	timestamps: { createdAt: "created_at", updatedAt: "updated_at" },
}

const siteVisitorsSchema = new schema(
	{
		numberOfSiteVisitors: {
			type: Number,
			required: true,
		},
	},
	schemaOptions
)

const siteVisitors = mongoose.model("siteVisitors", siteVisitorsSchema, "siteVisitors")

module.exports = siteVisitors
