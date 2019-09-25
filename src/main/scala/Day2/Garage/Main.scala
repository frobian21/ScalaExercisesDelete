package Day2.Garage

object Main extends App{
  class Person(name: String)
  class Employee(name: String, employeeID: String) extends Person(name: String){
    override def toString() = s"Employee($name,$employeeID)"
  }
  class Customer(name: String, customerID: String, vehicle: Vehicle) extends Person(name: String){
    override def toString() = s"Customer($name,$customerID,$vehicle)"
  }
  class Vehicle(ID: String, regNo: String)
  class Car(ID: String, regNo: String) extends Vehicle(ID: String, regNo: String){
    override def toString() = s"Car($ID,$regNo)"
  }
  class Bike(ID: String, regNo: String) extends Vehicle(ID: String, regNo: String){
    override def toString() = s"Bike($ID,$regNo)"
  }

  class Garage(){
//    val vehicles = new List[Vehicle]
//    val employees = new List[Employee]

  }
  
}
