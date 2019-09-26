package Day2.Garage

object Stage1 extends App{
  abstract case class Person(name: String)
  class Employee(name: String, employeeID: String) extends Person(name: String){
    override def toString() = s"Employee($name,$employeeID)"
  }
  class Customer(name: String) extends Person(name: String){
    override def toString() = s"Customer($name)"
  }
  abstract case class Vehicle(){
    val ID: String
    val regNo: String
    val make: String
    var isFixed: Boolean
    var days: Int
    val owner: Customer
  }
  object Vehicle{
    var ID = 100
    def generateID():String ={
      ID += 1
      ID.toString
    }
  }

  class Car(val ID: String, val regNo: String, val make: String, var isFixed: Boolean = false, var days: Int = 1, val owner: Customer) extends Vehicle {
    def this(regNo: String, make: String, owner: Customer) = this(Vehicle.generateID(), regNo, make, false, 1, owner)
    override def toString() = s"Car(ID $ID,regNo $regNo,make $make,isFixed $isFixed,days $days,owner $owner)"
  }

  class Bike(val ID: String, val regNo: String, val make: String, var isFixed: Boolean = false, var days: Int = 1, val owner: Customer) extends Vehicle {
    def this(regNo: String, make: String, owner: Customer) = this(Vehicle.generateID(), regNo, make, false, 1, owner)
    override def toString() = s"Bike(ID $ID,regNo $regNo,make $make,isFixed $isFixed,days $days,owner $owner)"
  }
}
