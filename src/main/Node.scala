package main

/**
  * The most basic unit of the graph
  */
import processing.core._
import vectors._


object Node {
  private var _lastId: Int = 0
}


class Node(pApp: PApplet) extends Circle(pApp){
  diameter = 60.0f

  // used for locating nodes
  protected var _depth: Int = 0
  protected var _id: Int = Node._lastId
  Node._lastId += 1
  protected var _visited = false
  protected var _parent: Node = null

  protected var _plusBubble = new PlusBubble(pApp, this)
  protected var _label = ""
  protected var _children: List[Node] = List[Node]()



  def adjRadius = _diameter * 2 + _plusBubble.diameter * 2 // how far away adjacent nodes are from this node


  def mousePressed(user: User): Unit = {
    _plusBubble.mousePressed(user)
    centeredOn(user)
  }

  /*
    Center on users current node.
   */
  def centeredOn(user: User): Unit = {
    if(contains(new Vector(pApp.mouseX, pApp.mouseY))) {
      // open dialog for adding description and name

      // center on new node
      if(user.current._id != _id) {
        _plusBubble.visible = true
        _plusBubble.enabled = true

        user.current._plusBubble.visible = false
        user.current._plusBubble.enabled = false

        user.centerOn(this)
        user.current = this
      }
    } else {
      _children.foreach(e => {
        e.centeredOn(user)
      })
    }
  }



  override def draw: Unit = {
    super.draw

/*    pApp.fill(0, 0, 0)
    pApp.textSize(20f)
    pApp.text(_depth + ":" + _id, position.x - pApp.textWidth(_depth + ":" + _id)/2, position.y + 10)
*/

    // draw plus bubble
    _plusBubble.draw

    _children.foreach(e => {
      e.draw
    })
  }

  /*
    Adds an adjacent node to this node.
   */
  def add(node: Node): Unit = {

    _children :+= node
    node._parent = this
    node._depth = _depth + 1

    // position all adjacent nodes
    for(i <- 0 until _children.length) {
      _children(i).position.x = _position.x + adjRadius * PApplet.cos((i / (_children.length.toFloat)) * PConstants.TWO_PI)
      _children(i).position.y = _position.y + adjRadius * PApplet.sin((i / (_children.length.toFloat)) * PConstants.TWO_PI)
      _children(i)._plusBubble.visible = false
      _children(i)._plusBubble.enabled = false
    }
  }

  /*
    Move the graph starting at this node by delta.
   */
  def move(delta: Vector): Unit = {
    position.x += delta.x
    position.y += delta.y

    _plusBubble.position.x += delta.x
    _plusBubble.position.y += delta.y

    _children.foreach(e => {
      e.move(delta)
    })


  }




  override def position_=(value: Vector): Unit = {
    position.x = value.x
    position.y = value.y

    _plusBubble.position.x = position.x
    _plusBubble.position.y = position.y + diameter / 2
  }

  override def x_=(value: Float): Unit = {
    position.x = value
    _plusBubble.position.x = position.x
  }

  override def y_=(value: Float): Unit = {
    position.y = value
    _plusBubble.position.y = position.y + diameter / 2
  }

  def children = _children
  def plusBubble = _plusBubble
  def depth = _depth
  def id = _id
  def parent = _parent


  def visited = _visited
  def visited_=(value: Boolean) = _visited = value


}
