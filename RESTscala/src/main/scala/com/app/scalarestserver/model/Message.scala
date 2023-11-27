package com.app.scalarestserver.model

import jakarta.persistence._

@Entity
class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = _

  @Column(nullable = false)
  var content: String = _

  @Column(nullable = false)
  var createdAt: java.sql.Timestamp = _

}