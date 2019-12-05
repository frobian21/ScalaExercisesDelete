package Garage

class Employee(name: String, employeeID: String) extends Person(name: String){
  override def toString() = s"Employee($name,$employeeID)"
}