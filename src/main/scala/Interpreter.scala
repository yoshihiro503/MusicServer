package org.proofcafe.android.socketserver

import scala.io.Source
import android.content.Context
import android.util.Log

class Interpreter(main : Context) {
  val TAG = "Interpreter"

  def lineInterpreter(lines : Iterator[String]): Iterator[String] = {
    val player = Player.create(main)
    lines takeWhile {
      line => line != "exit"
    } filter {
      line => line != ""
    } map {
      line =>
        if (line == "play") {
          player.play("TODO_filename")
          "PLAY"
        } else if (line == "stop") {
          player.stop()
          "STOP"
        } else {
          "unknown command: "+line
        }
    }
  }
}

object Interpreter {
  def apply(main : Context) = new Interpreter(main)
}
