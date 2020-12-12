package dialogs

import java.awt.TextField

import controlP5.{ControlP5}
import processing.core.PApplet
import vectors._

/**
  * Created by Gregory Venezia on 11/22/2015.
  */
class Dialog(pApp: PApplet, controlP5: ControlP5) {

  private var _position = new Vector()
  val description = controlP5.addTextfield("description")

  description
    .setPosition(500, 500)
    .setSize(100, 12)
    .setColorBackground(pApp.color(0, 255, 255))
    .setFont(pApp.createFont("arial", 12))
    .setColor(100)
    .setColorLabel(0)




  def hide: Unit = {
    description.setVisible(false)
    pApp.clear()
  }

  def show: Unit = {
    description.setVisible(true)
    pApp.clear()
  }

  def keyPressed: Unit = {

  }

  def draw: Unit = {
  }


  def position = _position
  def position_=(value: Vector) {
    _position.x = value.x
    _position.y = value.y

    description.setPosition(_position.x, _position.y)

  }

  def x = _position.x
  def x_=(value: Float) = {
    _position.x = value
    description.setPosition(_position.x, _position.y)
  }

  def y = _position.y
  def y_=(value: Float) = {
    _position.y = value
    description.setPosition(_position.x, _position.y)
  }
}
