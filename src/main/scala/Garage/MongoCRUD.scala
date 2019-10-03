package Garage

import org.mongodb.scala.MongoClient
import org.bson.{BsonArray, BsonDocument}
import org.mongodb.scala._
import org.mongodb.scala.bson.BsonValue
import org.mongodb.scala.model.Filters.{equal, _}
import org.mongodb.scala.model.Updates._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object MongoCRUD extends DBConnection {
  def openVehicleConnection(): (MongoClient, MongoCollection[Document])={
    (getClient(), getCollection(getDatabase(getClient(), "garage"), "vehicles"))
  }
  def openEmployeeConnection(): (MongoClient, MongoCollection[Document])={
    (getClient(), getCollection(getDatabase(getClient(), "garage"), "employees"))
  }
  def partsToDocument(parts: Array[Part]): Array[Document]={
    parts.map{part => s"{name: '${part.name}', isBroken: ${part.isBroken}, hoursToFix: ${part.hoursToFix}}"}
        .map(part =>Document( BsonDocument parse part))
  }
  def vehicleToDocument(vehicle: Vehicle): Document={
    var _type=""
    vehicle match {
      case _: Car =>_type = "Car"
      case _ => _type = "Bike"
    }
    Document(
      "ID" -> vehicle.ID,
      "type" -> _type,
      "regNo" -> vehicle.regNo,
      "make" -> vehicle.make,
      "isFixed" -> vehicle.isFixed,
      "owner" -> vehicle.owner.name,
      "parts" -> partsToDocument(vehicle.parts).toList
    )
  }
  def createVehicle(vehicle: Vehicle):Unit={
    val (mongoClient, vehicleCollection) = openVehicleConnection()
    vehicleCollection.insertOne(vehicleToDocument(vehicle))
      .subscribe(new Observer[Completed] {
      override def onNext(result: Completed):Unit = println("Inserted")
      override def onError(e: Throwable):Unit = println(s"Failed ${e.getStackTrace.toString}")
      override def onComplete(): Unit = println("Completed")
    })
    Thread.sleep(300)
    closeConnection(mongoClient)
  }
  def findVehicle(searchTerm:String):Unit={
    val (mongoClient, vehicleCollection) = openVehicleConnection()
    val vehicle = vehicleCollection.find(or(equal("make", searchTerm), equal("ID", searchTerm))).foreach(doc => documentToVehicle(doc))
    Thread.sleep(1000)
    closeConnection(mongoClient)
    vehicle
  }
  def updateVehicle(vehicle: Vehicle):Unit={
    val (mongoClient, vehicleCollection) = openVehicleConnection()
    vehicleCollection.findOneAndReplace(equal("ID", vehicle.ID), vehicleToDocument(vehicle)).headOption().onComplete{
      case Success(_) => println("Update Completed")
      case Failure(error) => error.printStackTrace()
    }
    Thread.sleep(1000)
    closeConnection(mongoClient)
  }
  def removeVehicle(searchID:String): Unit ={
    val (mongoClient, vehicleCollection) = openVehicleConnection()
    vehicleCollection.deleteOne(equal("ID", searchID)).headOption().onComplete{
      case Success(_) => println("Removal Completed")
      case Failure(error) => error.printStackTrace()
    }
    Thread.sleep(1000)
    closeConnection(mongoClient)
  }
  def documentToVehicle(vehicleDoc:Document):Vehicle={
    val parts:Array[Part] = documentToParts(vehicleDoc)
    val owner = new Customer(vehicleDoc.get("owner").get.asString().getValue)
    val ID = vehicleDoc.get("ID").get.asString().getValue
    val regNo = vehicleDoc.get("regNo").get.asString().getValue
    val make = vehicleDoc.get("make").get.asString().getValue
    val isFixed = vehicleDoc.get("isFixed").get.asBoolean().getValue
    vehicleDoc.get("type").get.asString().getValue match {
      case "Car" => Car(ID, regNo, make, isFixed, parts, owner)
      case "Bike" => Bike(ID, regNo, make, isFixed, parts, owner)
    }
  }
  def documentToParts(vehicleDoc:Document):Array[Part]={
    vehicleDoc.get("parts").get.asArray().toArray().map{
      case doc:BsonDocument => new Part(doc.get("name").asString().getValue, doc.get("isBroken").asBoolean().getValue, doc.get("hoursToFix").asInt32().getValue)
    }
  }
}