package com.app.scalarestserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication



@SpringBootApplication
class RestServerApplication {

}

object RestServerApplication extends App {
  SpringApplication.run(classOf[RestServerApplication])
}