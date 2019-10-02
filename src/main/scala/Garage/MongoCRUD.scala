package Garage

import org.mongodb.scala.bson.collection.mutable.Document
import org.mongodb.scala.{MongoClient, MongoDatabase}

object MongoCRUD extends DBConnection {
  def openVehicleConnection(): (MongoClient, Any) ={
    val mongoClient = getClient()
    val db = getDatabase(mongoClient, "garage")
    (mongoClient, getCollection(db, "vehicles"))

  }
  def PartsToDocument(parts: Array[Part]):Document ={
    parts.map{part => Document(
      "name" -> part.name,
      "isBroken" -> part.isBroken,
      "hoursToFix" -> part.hoursToFix
    )}.toIndexedSeq
  }
  def vehicleToDocument(vehicle: Vehicle):Document={
    Document(
      "regNo" -> vehicle.regNo,
      "make" -> vehicle.make,
      "isFixed" -> vehicle.isFixed,
//      "parts" -> partToDocument(parts)
      "owner" ->
    )
  }
  def createVehicle(vehicle: Vehicle)={
    val (mongoClient, vehicleCollection) = openVehicleConnection()

    closeConnection(mongoClient)
  }
  def findVehicle(searchTerm:AnyVal):Vehicle={
    case searchTerm:String =>
    case searchTerm:Vehicle =>
  }
  def updateVehicle(vehicle: Vehicle)={

  }
  def removeVehicle(searchID:String)={

  }
}
