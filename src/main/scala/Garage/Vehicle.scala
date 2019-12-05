package Garage

abstract class Vehicle() {
  val id: String
  val regNo: String
  val make: String
  val isFixed: Boolean
  val parts: Array[Part]
  val owner: Customer
}

object Vehicle {
  var id = 100

  def generateId(): String = {
    id += 1
    id.toString
  }
}