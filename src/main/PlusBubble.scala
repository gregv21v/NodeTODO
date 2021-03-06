package main

import controlP5.ControlP5
import processing.core.{PApplet, PConstants}
import vectors.Vector

/**
  * The button for adding nodes to nodes.
  */
class PlusBubble(pApp: PApplet, controlP5: ControlP5, node: Node) extends Bubble(pApp, controlP5, node) {
  position.x = node.position.x
  position.y = node.position.y + node.diameter / 2
  diameter = 20.0f
  color = pApp.color(0, 255, 0)
  visible = true

  def mousePressed(user: User): Unit = {
    if(contains(new Vector(pApp.mouseX, pApp.mouseY))) {
      node.add(new Node(pApp, controlP5))
      user.colorNodes
    } else {
      node.children.foreach(e => {
        e.plusBubble.mousePressed(user)
      })
    }
  }

  override def draw: Unit = {
    pApp.ellipseMode(PConstants.CENTER)
    if(visible) {
      pApp.noStroke()
      pApp.fill(_color)
      pApp.ellipse(_position.x, _position.y, _diameter, _diameter)
      pApp.fill(0, 0, 0)
      pApp.textAlign(PConstants.CENTER, PConstants.CENTER)
      pApp.text('+', _position.x + 1, _position.y)
    }
  }

}
