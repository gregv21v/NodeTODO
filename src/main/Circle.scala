package main

import processing.core.{PConstants, PApplet}
import vectors.Vector

/**
  * Circle shape
  */
class Circle(pApp: PApplet) {
  protected var _position = new Vector
  protected var _diameter = 60.0f
  protected var _color = pApp.color(255, 0, 0, 1)
  protected var _visible = true
  protected var _enabled = true





  def draw: Unit = {
    pApp.ellipseMode(PConstants.CENTER)
    if(visible) {
      pApp.noStroke()
      pApp.fill(_color)
      pApp.ellipse(_position.x, _position.y, _diameter, _diameter)
    }

  }






  def contains(point: Vector): Boolean = {
    if(_enabled)
      position.distance(point) <= _diameter/2
    else
      false
  }

  def position = _position
  def position_=(value: Vector) {
    _position.x = value.x
    _position.y = value.y
  }

  def x = _position.x
  def x_=(value: Float) = {
    _position.x = value
  }

  def y = _position.y
  def y_=(value: Float) = {
    _position.y = value
  }

  def diameter = _diameter
  def diameter_=(value: Float) = {
    _diameter = value
  }

  def color = _color
  def color_=(value: Int) {
    _color = value
  }


  def visible = _visible
  def visible_=(value: Boolean) = _visible = value

  def enabled = _enabled
  def enabled_=(value: Boolean) = _enabled = value
}
