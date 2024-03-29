package Garage

import org.bson.BsonDocument
import org.mongodb.scala._
import org.mongodb.scala.bson.{BsonArray, BsonBoolean, BsonString}
import org.mongodb.scala.model.Filters.{equal, or}

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
    val vehicleType = vehicle match {
      case _: Car => "Car"
      case _ => "Bike"
    }
    Document(
      "id" -> vehicle.id,
      "type" -> vehicleType,
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
    vehicleCollection.find(or(equal("make", searchTerm), equal("id", searchTerm))).foreach(doc => documentToVehicle(doc))
    Thread.sleep(1000)
    closeConnection(mongoClient)
  }
  def updateVehicle(vehicle: Vehicle):Unit={
    val (mongoClient, vehicleCollection) = openVehicleConnection()
    vehicleCollection.findOneAndReplace(equal("id", vehicle.id), vehicleToDocument(vehicle)).headOption().onComplete{
      case Success(_) => println("Update Completed")
      case Failure(error) => error.printStackTrace()
    }
    Thread.sleep(1000)
    closeConnection(mongoClient)
  }
  def removeVehicle(searchid:String): Unit ={
    val (mongoClient, vehicleCollection) = openVehicleConnection()
    vehicleCollection.deleteOne(equal("id", searchid)).headOption().onComplete{
      case Success(_) => println("Removal Completed")
      case Failure(error) => error.printStackTrace()
    }
    Thread.sleep(1000)
    closeConnection(mongoClient)
  }
  def documentToVehicle(vehicleDoc:Document):Vehicle={
    val parts:Array[Part] = documentToParts(vehicleDoc)
    val owner = new Customer(vehicleDoc.get("owner").getOrElse(BsonString.apply("NONE")).asString().getValue)
    val id = vehicleDoc.get("id").getOrElse(BsonString.apply("NONE")).asString().getValue
    val regNo = vehicleDoc.get("regNo").getOrElse(BsonString.apply("NONE")).asString().getValue
    val make = vehicleDoc.get("make").getOrElse(BsonString.apply("NONE")).asString().getValue
    val isFixed = vehicleDoc.get("isFixed").getOrElse(BsonBoolean.apply(false)).asBoolean().getValue
    vehicleDoc.get("type").getOrElse(BsonString.apply("Car")).asString().getValue match {
      case "Car" => Car(id, regNo, make, isFixed, parts, owner)
      case "Bike" => Bike(id, regNo, make, isFixed, parts, owner)
    }
  }
  def documentToParts(vehicleDoc:Document):Array[Part]={
    vehicleDoc.get("parts").getOrElse(BsonArray.apply()).asArray().toArray().map{
      case doc:BsonDocument => new Part(doc.get("name").asString().getValue, doc.get("isBroken").asBoolean().getValue, doc.get("hoursToFix").asInt32().getValue)
    }
  }
}