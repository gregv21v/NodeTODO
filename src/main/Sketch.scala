package main

import processing.core.{PApplet}


object Sketch extends PApplet {
  private var user: User = _


  override def settings(): Unit = {
    size(1000, 1000)



  }

  override def setup: Unit = {
    user = new User(this)
    for(i <- 0 until 5)
      user.add(new Node(this))

  }

  override def draw {
    background(255, 255, 255)
    user.draw

  }

  override def mousePressed: Unit = {
    user.mousePressed
  }

  override def mouseDragged: Unit = {
    user.mouseDragged
  }

  override def mouseReleased: Unit = {
    user.mouseReleased
  }

}