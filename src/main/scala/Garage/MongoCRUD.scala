package Garage

import org.mongodb.scala.MongoClient
import org.bson.{BsonDocument, BsonArray}
import org.mongodb.scala._
import org.mongodb.scala.model.Filters.{equal, _}
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
    vehicleCollection.find(or(equal("make",searchTerm),equal("ID", searchTerm))).foreach(doc => println(doc.toJson()))
    Thread.sleep(1000)
    closeConnection(mongoClient)
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

  //  def documentToCar(value:Document):Vehicle={
  //    new Car(value.get("ID").asInstanceOf[String],
  //      value.get("regNo").asInstanceOf[String],
  //      value.get("make").asInstanceOf[String],
  //      value.get("isFixed").asInstanceOf[Boolean],
  //      value.get("parts"),
  //      value.get("owner"))
  //  }
  //  def documentToBike(value:Document)={
  //    new Bike(value.get("ID").asInstanceOf[String],
  //      value.get("regNo").asInstanceOf[String],
  //      value.get("make").asInstanceOf[String],
  //      value.get("isFixed").asInstanceOf[Boolean],
  //      documentToParts(value.get("parts").asInstanceOf[BsonArray[Document]]),
  //      value.get("owner"))
  //  }
  //  def documentToParts(value:BsonArray[Document]):Array[Part]={
  //    value.forEach(a => a.asInstanceOf[BsonDocument]).toArray
  //  }
  //
  //  }
}