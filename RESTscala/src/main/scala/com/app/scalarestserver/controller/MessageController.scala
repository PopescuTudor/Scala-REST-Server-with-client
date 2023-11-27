package com.app.scalarestserver.controller
import com.app.scalarestserver.model.{Message, Tag}
import com.app.scalarestserver.repository.{MessageRepository, TagRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

import java.sql.{Date, Timestamp}

@RestController
@RequestMapping(Array("/api"))
class MessageController @Autowired()(val messageRepository: MessageRepository,
                                     val tagRepository: TagRepository) {
  // Endpoint for posting messages
  @PostMapping(Array("/message"))
  def createMessage(@RequestBody content: String): Unit = {

    // Parse the content to extract and store tags
    val message = new Message()
    message.content = content
    message.createdAt = new Timestamp(System.currentTimeMillis())
    messageRepository.save(message)

    // logic to parse and store tags in the database
    val tagsRegex = "\\[([^:]+):([^\\]]+)\\]".r
    val tags = tagsRegex.findAllMatchIn(content).map(m => (m.group(1), m.group(2))).toList
    tags.foreach { case (tagName, tagValue) =>
      val tag = new Tag()
      tag.tagName = tagName
      tag.tagValue = tagValue
      tag.messageId = message.id
      tagRepository.save(tag)
    }
  }
}