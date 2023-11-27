package com.app.scalarestserver.controller

import com.app.scalarestserver.model.{Message, Tag}
import com.app.scalarestserver.repository.{MessageRepository, TagRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

import scala.jdk.CollectionConverters.CollectionHasAsScala

import java.sql.{Date, Timestamp}

@RestController
@RequestMapping(Array("/api"))
class StatisticsController @Autowired()(val messageRepository: MessageRepository,
                                     val tagRepository: TagRepository) {

  @GetMapping(Array("/statistics"))
  def getStatistics(
                     @RequestParam startTime: Timestamp,
                     @RequestParam endTime: Timestamp
                   ): String = {
    // Implement the logic to retrieve and calculate statistics
    val messagesInDateRange = messageRepository.findByCreatedBetween(startTime, endTime)

    val tagsInDateRange = new java.util.ArrayList[Tag]()
    for (m <- messagesInDateRange.asScala) {
      val tags = tagRepository.findByMessageId(m.id)
      for (t <- tags.asScala) {
        tagsInDateRange.add(t)
      }
    }

    val tagsPerMessage = tagsInDateRange.asScala.groupBy(_.messageId).view.mapValues(_.size).toMap
    val hardcodedResponse = StatisticsResponse(totalTags = tagsInDateRange.size(), tagsPerMessage = tagsPerMessage, messagesInDateRange = messagesInDateRange.size())

    // Return the statistics as a JSON string
    val jsonString: String =
      s"""
        |{
        |  "totalTags": ${hardcodedResponse.totalTags},
        |  "messagesInDateRange": ${hardcodedResponse.messagesInDateRange},
        |  "tagsPerMessage": ${hardcodedResponse.tagsPerMessage}
        |}
        |""".stripMargin

    jsonString
  }
}
