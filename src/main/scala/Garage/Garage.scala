package Garage

class Garage(){
  var vehicles = List[Vehicle]()
  var employees = List[Employee]()
  var isOpen: Boolean = true

  def addVehicle(vehicle: Vehicle): Unit ={
    vehicles ::= vehicle
  }
  def removeVehicle(searchTerm: String): Unit ={
    vehicles = vehicles.filter(_.ID != searchTerm).filter(_.make != searchTerm)
  }
  def registerEmployee(employee: Employee)={
    employees ::= employee
  }
  def fixVehicle(searchID: String): Unit ={
    vehicles.filter(_.ID==searchID).foreach(_.isFixed=true)
  }
  def getContents(): Unit ={
    println("Garage contents are:")
    vehicles.map(println(_))
  }
  def openGarage(): Unit ={
    if(isOpen==false){
      isOpen = true
      vehicles.foreach(_.days += 1)
    }
  }
  def closeGarage(): Unit ={
    if(isOpen) isOpen=false
  }
//  def calculateBills(vehicle: Vehicle) = {
//    case vehicle:Car => println(s"Bill is £${vehicle.days*50}")
//    case vehicle: Bike => println(s"Bill is £${vehicle.days*35}")
//  }
}
