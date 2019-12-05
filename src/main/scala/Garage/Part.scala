package Garage

import java.security.SecureRandom

case class Part(name: String, var isBroken: Boolean, var hoursToFix: Int = 0)

object Part{
  val acceptedParts:Set[String] = Set("door", "bonnet", "window", "engine", "tires", "seat", "bumper",
    "exhaust", "radio", "headlights", "warning lights", "mirrors", "windscreen wipers", "airbag", "brakes")
  def generatePartList(numberOfParts:Int=10):Array[Part]={
    var partList= List[Part]()
    (0 until numberOfParts).foreach(_ => partList ::= generate(getPartSet))

    def getPartSet:Set[String]= acceptedParts--partList.collect{ case part:Part=>part.name}

    def generate(nameSet:Set[String]):Part= {
      val chosenName = nameSet.toVector(new SecureRandom().nextInt(nameSet.size))
      val isBroken = new SecureRandom().nextBoolean()
      if (isBroken) Part(chosenName, isBroken, new SecureRandom().nextInt( 3)+1)
      else Part(chosenName, isBroken)
    }
    partList.toArray
  }
}