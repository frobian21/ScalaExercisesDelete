package Garage

import .Customer

class Bike(val ID: String, val regNo: String, val make: String, var isFixed: Boolean = false, var days: Int = 1, val owner: Customer) extends Vehicle {
  def this(regNo: String, make: String, owner: Customer) = this(Vehicle.generateID(), regNo, make, false, 1, owner)
  override def toString() = s"Bike(ID $ID,regNo $regNo,make $make,isFixed $isFixed,days $days,owner $owner)"
}
