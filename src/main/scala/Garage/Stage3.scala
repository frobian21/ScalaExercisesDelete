package Garage

object Main extends App{
  val garage = new Garage()
  garage.addVehicle(new Car("myreg", "Honda", new Customer("James")))
  garage.getContents()
  garage.vehicles.map{case car:Car => car.parts.foreach(println(_))}
  val car = new Car("myreg", "Ford", new Customer("James"))
  MongoCRUD.createVehicle(car)
  MongoCRUD.findVehicle(car.ID)
  MongoCRUD.updateVehicle(car.copy(regNo="abcd", make="Honda"))
  MongoCRUD.findVehicle(car.ID)
  MongoCRUD.removeVehicle(car.ID)
  MongoCRUD.findVehicle(car.ID)
  val doc = MongoCRUD.vehicleToDocument(new Bike("hello", "my", new Customer("friends")))
  println(MongoCRUD.documentToVehicle(doc).toString())

}
