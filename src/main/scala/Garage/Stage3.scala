package Garage

object Main extends App{
  val garage = new Garage()
  garage.addVehicle(new Car("myreg", "Honda", new Customer("James")))
  garage.getContents()
//  garage.vehicles.map{case car:Car => car.parts.foreach(println(_))}
  val car = new Car("myreg", "Ford", new Customer("James"))
  MongoCRUD.createVehicle(car)
  MongoCRUD.findVehicle(car.id)
  MongoCRUD.updateVehicle(car.copy(regNo="abcd", make="Honda"))
  MongoCRUD.findVehicle(car.id)
  MongoCRUD.removeVehicle(car.id)
  MongoCRUD.findVehicle(car.id)
  val doc = MongoCRUD.vehicleToDocument(new Bike("hello", "my", new Customer("friends")))
  println(MongoCRUD.documentToVehicle(doc).toString)

}
