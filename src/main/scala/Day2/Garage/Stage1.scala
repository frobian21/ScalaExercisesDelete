package Day2.Garage

object Stage1 extends App{
  abstract case class Person(name: String)
  class Employee(name: String, employeeID: String) extends Person(name: String){
    override def toString() = s"Employee($name,$employeeID)"
  }
  class Customer(name: String) extends Person(name: String){
    override def toString() = s"Customer($name)"
  }
  abstract case class Vehicle(ID: String, regNo: String, owner: Customer)
  class Car(ID: String, regNo: String, owner: Customer) extends Vehicle(ID: String, regNo: String, owner: Customer){
    override def toString() = s"Car($ID,$regNo,$owner)"
  }
  class Bike(ID: String, regNo: String, owner: Customer) extends Vehicle(ID: String, regNo: String, owner: Customer){
    override def toString() = s"Bike($ID,$regNo,$owner)"
  }
}
