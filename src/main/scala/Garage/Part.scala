package Garage

import scala.util.Random

case class Part(name: String, var isBroken: Boolean, var hoursToFix: Int = 0)

object Part{
  val acceptedParts:Set[String] = Set("door", "bonnet", "window", "engine", "tires", "seat", "bumper",
    "exhaust", "radio", "headlights", "warning lights", "mirrors", "windscreen wipers", "airbag", "brakes")
  def generatePartList(numberOfParts:Int=10):Array[Part]={
    var partList= List[Part]()
    (0 until numberOfParts).foreach(_ => partList ::= generate(getPartSet))

    def getPartSet:Set[String]= acceptedParts--partList.collect{ case part:Part=>part.name}

    def generate(nameSet:Set[String]):Part= {
      val chosenName = nameSet.toVector(Random.nextInt(nameSet.size))
      val isBroken = Random.nextFloat() > 0.5
      if (isBroken) Part(chosenName, isBroken, Random.between(1, 4))
      else Part(chosenName, isBroken)
    }
    partList.toArray
  }
}