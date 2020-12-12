package main

import controlP5.ControlP5
import processing.core.{PApplet, PVector}

class Bubble(pApp: PApplet, controlP5: ControlP5, node: Node) extends Circle(pApp) {


  /**
   * setPositionByAngle()
   * Sets the position of the Bubble around the Node
   * @param degree angle in degrees to use to set the position
   */
  def setPositionByAngle(degree: Float): Unit = {
    position.x = (node.position.x + Math.cos(degree * Math.PI / 180) * (node.diameter / 2)).toFloat
    position.y = (node.position.y + Math.sin(degree * Math.PI / 180) * (node.diameter / 2)).toFloat
  }
}
