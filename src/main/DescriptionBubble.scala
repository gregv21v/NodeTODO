package main

import java.util.ResourceBundle.Control

import controlP5.ControlP5
import processing.core.{PApplet, PConstants, PVector}
import vectors.Vector
import dialogs._

/**
  * The button for adding nodes to nodes.
  */
class DescriptionBubble(pApp: PApplet, controlP5: ControlP5, node: Node) extends Bubble(pApp, controlP5, node) {
  position.x = node.position.x
  position.y = node.position.y + node.diameter / 2
  diameter = 20.0f
  color = pApp.color(105, 105, 0)
  visible = true
  val dialog = new Dialog(pApp, controlP5)

  def mousePressed(user: User): Unit = {
    // open description dialog
    if(contains(new Vector(pApp.mouseX, pApp.mouseY))) {
      println("Showing...")

      dialog.show
    }

  }

  def keyPressed: Unit = {
    dialog.keyPressed
  }

  override def draw: Unit = {
    pApp.ellipseMode(PConstants.CENTER)
    if(visible) {
      pApp.noStroke()
      pApp.fill(_color)
      pApp.ellipse(_position.x, _position.y, _diameter, _diameter)
      pApp.fill(0, 0, 0)
      pApp.textAlign(PConstants.CENTER, PConstants.CENTER)
      pApp.text('D', _position.x + 1, _position.y)
    }
  }

}
