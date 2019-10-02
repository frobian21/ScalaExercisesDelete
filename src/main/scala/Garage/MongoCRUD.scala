package Garage

import org.mongodb.scala.MongoClient
import org.bson.BsonDocument

import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Updates._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object MongoCRUD extends DBConnection {
  def openVehicleConnection(): (MongoClient, MongoCollection[Document]) ={
    val mongoClient = getClient()
    val db = getDatabase(mongoClient, "garage")
    (mongoClient, getCollection(db, "vehicles"))
  }
  def openEmployeeConnection(): (MongoClient, MongoCollection[Document]) ={
    val mongoClient = getClient()
    val db = getDatabase(mongoClient, "garage")
    (mongoClient, getCollection(db, "customers"))
  }
  def partsToDocument(parts: Array[Part]):Array[Document] ={
    parts.map{part => s"{name: '${part.name}', isBroken: ${part.isBroken}, hoursToFix: ${part.hoursToFix}}"}
        .map(part =>Document( BsonDocument parse part))
  }
  def vehicleToDocument(vehicle: Vehicle):Document={
    var _type = ""
    vehicle match {
      case _: Car =>_type = "Car"
      case _ => _type = "Bike"
    }
    Document(
      "type" -> _type,
      "regNo" -> vehicle.regNo,
      "make" -> vehicle.make,
      "isFixed" -> vehicle.isFixed,
      "owner" -> vehicle.owner.name,
      "parts" -> partsToDocument(vehicle.parts).toList
    )
  }
  def createVehicle(vehicle: Vehicle)={
    val (mongoClient, vehicleCollection) = openVehicleConnection()
    vehicleCollection.insertOne(vehicleToDocument(vehicle))
      .subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = println("Inserted")
      override def onError(e: Throwable): Unit = println(s"Failed ${e.getStackTrace.toString}")
      override def onComplete(): Unit = println("Completed")
    })
    Thread.sleep(300)
    closeConnection(mongoClient)
  }
  def findVehicle(searchTerm:AnyVal):Vehicle={
    val (mongoClient, vehicleCollection) = openVehicleConnection()
    case searchTerm:String => vehicleCollection.find[Document](s"{make:'$searchTerm'}")
    case searchTerm:Vehicle =>
  }
//  def updateVehicle(vehicle: Vehicle)={
//
//  }
//  def removeVehicle(searchID:String)={
//
//  }
}
