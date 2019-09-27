package Garage

import scala.util.Random

case class Part(val name: String, var isBroken: Boolean, var hoursToFix: Int = 0)

object Part{
  val acceptedParts = Set[String]("door", "bonnet", "window", "engine", "tires", "seat", "bumper",
    "exhaust", "radio", "headlights", "warning lights", "mirrors", "windscreen wipers", "airbag", "brakes")
  def generatePartList(numberOfParts:Int=10):Array[Part]={
    var partList= List[Part]()
    (0 until numberOfParts).foreach(_ => partList ::= generatePart(getPartSet()))

    def getPartSet():Set[String]= acceptedParts--partList.collect{ case part:Part=>part.name}

    def generatePart(nameSet:Set[String]):Part= {
      val chosenName = nameSet.toVector(Random.nextInt(nameSet.size))
      Random.nextFloat() > 0.5 match {
        case true => Part(chosenName, true, Random.between(1, 4))
        case false => Part(chosenName, false, 0)
      }
    }
    partList.toArray
  }
}