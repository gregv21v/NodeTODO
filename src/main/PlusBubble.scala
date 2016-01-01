package main

import processing.core.PApplet
import vectors.Vector

/**
  * The button for adding nodes to nodes.
  */
class PlusBubble(pApp: PApplet, node: Node) extends Circle(pApp) {
  position.x = node.position.x
  position.y = node.position.y + node.diameter / 2
  diameter = 20.0f
  color = pApp.color(0, 255, 0)
  visible = true

  def mousePressed(user: User): Unit = {
    if(contains(new Vector(pApp.mouseX, pApp.mouseY))) {
      node.add(new Node(pApp))
      user.colorNodes
    } else {
      node.children.foreach(e => {
        e.plusBubble.mousePressed(user)
      })
    }
  }

}
