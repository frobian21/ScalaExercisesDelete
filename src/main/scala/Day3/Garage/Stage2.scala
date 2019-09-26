package Day3.Garage

import Day2.Garage.Stage1._

object Stage2 extends App{
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
    def garageContents(): Unit ={
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
    def calculateBills(vehicle: Vehicle): Unit = {
      case vehicle:Car => println(s"Bill is £${vehicle.days*50}")
      case vehicle: Bike => println(s"Bill is £${vehicle.days*35}")
    }
    addVehicle(new Car("ab3 rg4", "Honda", new Customer("Jim")))
    addVehicle(new Car("ab3 rg4", "Honda", new Customer("Jim")))
    addVehicle(new Bike("ab3 rg43", "Honda", new Customer("Jim")))
    addVehicle(new Bike("ab3 rg43", "Honda", new Customer("Jim")))
    addVehicle(new Bike("ab3 rg24", "Suzuki", new Customer("Jim")))
    garageContents()
    removeVehicle("101")
    garageContents()
    removeVehicle("Suzuki")
    garageContents()
    closeGarage()
    openGarage()
    garageContents()
  }
  new Garage()
}
