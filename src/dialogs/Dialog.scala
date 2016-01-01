package dialogs

import controlP5.{Textarea, ControlP5}
import processing.core.PApplet
import vectors._

/**
  * Created by Gregory Venezia on 11/22/2015.
  */
class Dialog(controlP5: ControlP5, pApp: PApplet) {

  private var _position = new Vector()
  private var description = new Textarea(controlP5, "description")

  description.setPosition(500, 500)
  description.setSize(100, 100)
  description.setLineHeight(10)
  description.setFont(pApp.createFont("arial",12))
  description.setColor(100)
  description.setText("Testing")





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
