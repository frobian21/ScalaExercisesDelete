package Garage

case class Car(val Id: String, val regNo: String, val make: String, val isFixed: Boolean = false, val parts: Array[Part], val owner: Customer) extends Vehicle {
  def this(regNo: String, make: String, owner: Customer) = this(Vehicle.generateID(), regNo, make, false, Part.generatePartList(), owner)
  override def toString() = s"Car(ID $Id,regNo $regNo,make $make,isFixed $isFixed,broken parts ${parts.count(_.isBroken)},owner $owner)"
}

