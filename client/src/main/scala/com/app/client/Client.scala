package com.app.client

import java.util.Scanner
import org.springframework.web.client.RestTemplate

import scala.io.StdIn

object Client {
  def main(args: Array[String]): Unit = {


    val restTemplate = new RestTemplate()
    val serverUrl = "http://localhost:8080/api/message"

    while (true) {
      print("Enter a message (or type 'exit' to quit): \n")
      val input = StdIn.readLine()

      if (input.toLowerCase == "exit") {
        println("Exiting...")
        System.exit(0)
      }
      else if (input.isEmpty) {
        println("Empty message. Try again.\n")
      }
      else if (input.toLowerCase().contains("/stats")) {
        val regex = """^/stats (?!0000)[1-9]\d{3}-(?!00)\d{2}-(?!00)\d{2} \d{2}:\d{2}:\d{2} (?!0000)[1-9]\d{3}-(?!00)\d{2}-(?!00)\d{2} \d{2}:\d{2}:\d{2}$""".r
        if (!regex.matches(input)) {
          println("Invalid input. Try again. \n")
        }
        else {
          val startTime = input.split(" ")(1) + " " + input.split(" ")(2)
          val endTime = input.split(" ")(3) + " " + input.split(" ")(4)
          val statsUrl = "http://localhost:8080/api/statistics?startTime=" + startTime + "&endTime=" + endTime
          val stats = restTemplate.getForObject(statsUrl, classOf[String])
          println(stats)
        }
      }
      else {
        restTemplate.postForObject(serverUrl, input, classOf[Unit])
        println("Message sent to server. \n")
      }
    }
  }
}