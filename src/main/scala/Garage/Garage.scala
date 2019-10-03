package Garage

class Garage(){
  var isOpen: Boolean = true

  def addVehicle(vehicle: Vehicle): Unit ={
    MongoCRUD.createVehicle(vehicle)
  }
  def removeVehicle(searchTerm: String): Unit ={
    MongoCRUD.removeVehicle(searchTerm)
  }
  def registerEmployee(employee: Employee): Unit ={
    employees ::= employee
  }
  def fixVehicle(searchID: String): Unit ={
//    vehicles.filter(_.ID==searchID).foreach(_.isFixed=true)
  }
  def getContents(): Unit ={
    println("Garage contents are:")
    vehicles.foreach(println(_))
  }
  def openGarage(): Unit ={
    if (!isOpen){
      isOpen = true
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

