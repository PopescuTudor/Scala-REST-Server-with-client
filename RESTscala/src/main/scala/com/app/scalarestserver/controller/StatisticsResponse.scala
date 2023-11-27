package com.app.scalarestserver.controller

// Response class to return the statistics
case class StatisticsResponse(
                               totalTags: Int,
                               tagsPerMessage: Map[Long, Int],
                               messagesInDateRange: Int
                             )