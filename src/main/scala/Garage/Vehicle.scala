package Garage

import scala.util.Random

abstract class Vehicle(){
  val Id: String
  val regNo: String
  val make: String
  val isFixed: Boolean
  val parts: Array[Part]
  val owner: Customer
}
object Vehicle{
  var ID = 100
  def generateID():String ={
    ID += 1
    ID.toString
  }
}