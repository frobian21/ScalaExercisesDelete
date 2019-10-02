package Garage

object Main extends App{
  import scala.util.Random
  val garage = new Garage()
  garage.addVehicle(new Car("myreg", "Honda", new Customer("James")))
  garage.getContents()
  garage.vehicles.map{case car:Car => car.parts.foreach(println(_))}
  MongoCRUD.createVehicle(new Car("myreg", "Honda", new Customer("James")))
}
