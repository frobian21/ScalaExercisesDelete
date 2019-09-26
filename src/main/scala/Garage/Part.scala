package Garage

import scala.util.Random

case class Part(val name: String, var isBroken: Boolean, var hoursToFix: Int = 0)
object Part{
  val acceptedParts = Set[String]("door", "bonnet", "window", "engine", "tires", "seat", "bumper",
    "exhaust", "radio", "headlights", "warning lights", "mirrors", "windscreen wipers", "airbag", "brakes")
  def generatePartList(numberOfParts:Int=10):Array[Part]={
    var partList= List[Part]()
    (0 until numberOfParts).foreach(_ => partList ::= Part(getPartName(), Random.nextFloat()>0.5, Random.between(1,4)))
    def getPartName():String={
      val partSet = (acceptedParts--partList.collect{ case part:Part=>part.name})
        partSet.toVector(Random.nextInt(partSet.size))
    }
//    def getBrokenStateAndRepairTime:(Boolean, Int)={
//      if (Random.nextFloat()>0.5) (true, Random.between(1,4)) else (false,0)
//    }
    partList.toArray
  }
}