package com.app.scalarestserver.repository
import com.app.scalarestserver.model.{Message, Tag}
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait MessageRepository extends JpaRepository[Message, Long] {

  def findByCreatedBetween(start: java.sql.Timestamp,
                           end: java.sql.Timestamp): java.util.List[Message] = {

    val messages = findAll()
    messages.removeIf(m => m.createdAt.before(start) || m.createdAt.after(end))
    messages
  }

}
