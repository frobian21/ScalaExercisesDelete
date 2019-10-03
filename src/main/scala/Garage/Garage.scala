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
  //useMongoDB
  }
  def fixVehicle(searchID: String): Unit ={
  //useMongoDB
  }
  def getContents(): Unit ={
  //use MongoDB
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

