package main



import processing.core.PApplet
import vectors._

/**
  * The user is where the graph starts
  */
class User(pApp: PApplet) {
  private val _root: Node = new Node(pApp)
  private var _current: Node = _
  private var _start: Vector = new Vector()
  private var _lastDrag: Vector = new Vector()
  current = _root


  private val _maxDepth = 5

  def draw: Unit = {
    _root.draw
  }


  def mousePressed: Unit = {
    _root.mousePressed(this)
    _start = new Vector(pApp.mouseX, pApp.mouseY)
  }


  def mouseDragged: Unit = {
    val delta = new Vector(pApp.mouseX - _start.x , pApp.mouseY -_start.y)

    _root.move(new Vector(-_lastDrag.x, -_lastDrag.y))
    _root.move(delta)

    _lastDrag = new Vector(pApp.mouseX - _start.x , pApp.mouseY -_start.y)
  }




  def mouseReleased: Unit = {
    val delta = new Vector(pApp.mouseX - _start.x , pApp.mouseY -_start.y)
  }


  /*
    Center the graph on "node".
   */
  def centerOn(node: Node): Unit = {
    val delta = new Vector(current.x - node.x, current.y - node.y)

    // move all nodes in the graph by that amount
    _root.move(delta)
  }




  /*
    Adds a node adjacent to the current node.
   */
  def add(node: Node): Unit = {
    _current.add(node)
    colorNodes
  }

  /*
    Color the nodes of the graph, where every node from "node" is more transparent.
   */
  def colorChildren(node: Node, depth: Int = 0): Unit = {
    if(node != null) {
      if(depth <= _maxDepth)
        node.color = pApp.color(0, 0, 255, (_maxDepth - depth) * (255f / _maxDepth))
      else
        node.color = pApp.color(0, 0, 255, 255)
      node.visited = true
      println("Coloring: " + node.id)
      node.children.foreach(e => {
         if(!e.visited)
          colorChildren(e, depth + 1)
      })

      if(node.parent != null && !node.parent.visited) {
        colorChildren(node.parent, depth + 1)
      }
    }

  }

  /*
    Unvisit the children of "node".
   */
  def unvisitChildren(node: Node): Unit = {
    node.visited = false
    node.children.foreach(e => {
      unvisitChildren(e)
    })

    if(node.parent != null && node.parent.visited) {
      unvisitChildren(node.parent)
    }
  }

  /*
    Color the nodes starting at the current node.
   */
  def colorNodes: Unit = {
    if(_current != null) {
      println("-----------")
      colorChildren(_current)
      unvisitChildren(_root)
    }
  }



  def current = _current
  def current_=(value: Node) = {
    _current = value
    _current.x = pApp.width/2
    _current.y = pApp.height/2

    colorNodes
  }

}
