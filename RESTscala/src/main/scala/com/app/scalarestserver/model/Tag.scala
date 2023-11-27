package com.app.scalarestserver.model

import jakarta.persistence._

@Entity
class Tag {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = _

  @Column(nullable = false)
  var messageId: Long = _

  @Column(nullable = false)
  var tagName: String = _

  @Column(nullable = false)
  var tagValue: String = _



}
