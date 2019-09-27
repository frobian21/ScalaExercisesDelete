package Garage

class Car(val ID: String, val regNo: String, val make: String, var isFixed: Boolean = false, var days: Int = 1, val parts: Array[Part], val owner: Customer) extends Vehicle {
  def this(regNo: String, make: String, owner: Customer) = this(Vehicle.generateID(), regNo, make, false, 1, Part.generatePartList(), owner)
  override def toString() = s"Car(ID $ID,regNo $regNo,make $make,isFixed $isFixed,days $days,broken parts ${parts.count(_.isBroken)},owner $owner)"
}
