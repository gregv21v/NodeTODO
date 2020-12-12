package main

import controlP5.ControlP5
import processing.core.PApplet

object Sketch extends PApplet {
  private var user: User = _
  private var controlP5: ControlP5 = _

  /**
    settings()
    @description all the settings of the sketch go here.

   */
  override def settings(): Unit = {
    size(1000, 700)
  }

  /**
    setup()
    @description setup any custom variables here

   */
  override def setup: Unit = {
    controlP5 = new ControlP5(this)
    user = new User(this, controlP5)
    for(i <- 0 until 5)
      user.add(new Node(this, controlP5))

  }

  /**
  draw()
  @description this is where everything is drawn
   */
  override def draw {
    background(255, 255, 255)
    user.draw

  }

  /**
  mousePressed()
  @description actions taken when the mouse is pressed
   */
  override def mousePressed: Unit = {
    user.mousePressed
  }

  override def mouseDragged: Unit = {
    user.mouseDragged
  }

  override def mouseReleased: Unit = {
    user.mouseReleased
  }

  override def keyPressed: Unit = {
    user.keyPressed
  }

}