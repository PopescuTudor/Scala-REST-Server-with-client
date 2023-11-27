package com.app.scalarestserver.repository

import com.app.scalarestserver.model.Tag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait TagRepository extends JpaRepository[Tag, Long] {
  def findByMessageId(messageId: Long): java.util.List[Tag] = {
    val tags = findAll()
    tags.removeIf(t => t.messageId != messageId)
    tags
  }
}
