package Garage

case class Bike(val id: String, val regNo: String, val make: String, val isFixed: Boolean = false, val parts: Array[Part], val owner: Customer) extends Vehicle {
  def this(regNo: String, make: String, owner: Customer) = this(Vehicle.generateId(), regNo, make, false, Part.generatePartList(), owner)
  override def toString() = s"Bike(ID $id,regNo $regNo,make $make,isFixed $isFixed,broken parts ${parts.count(_.isBroken)},owner $owner)"
}
