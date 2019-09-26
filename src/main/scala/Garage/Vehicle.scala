package Garage

import scala.util.Random

abstract case class Vehicle(){
  val ID: String
  val regNo: String
  val make: String
  var isFixed: Boolean
  var days: Int
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