package org.proofcafe.android.socketserver

import java.io.File
import android.net.Uri
import android.media.MediaPlayer
import scala.io.Source
import android.content.Context
import android.util.Log

class Player(main : Context) {
  var player : MediaPlayer = null

  def play (mp3file : String) = {
    //val uri = Uri.fromFile(new File("android_asset/"+mp3file))
    //Log.d(TAG, "uri = "+uri)
    player =  MediaPlayer.create(main, R.raw.orch128)
    //player.prepare()
    player.start()
  }

  def stop() = {
    player.stop()
  }
}

object Player {
  def create(main : Context) = new Player(main)
}
