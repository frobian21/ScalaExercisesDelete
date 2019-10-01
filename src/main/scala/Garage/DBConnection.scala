package Garage

import org.mongodb.scala.{MongoClient, MongoDatabase}

object DBConnection {
  // Get connection
  val mongoClient: MongoClient = MongoClient("mongodb://localhost")
  // Get database
  def getConnection():Unit ={
    val database: MongoDatabase = mongoClient.getDatabase("test")
    // Get collection
    val testCollection = database.getCollection("test")
  }
  def closeConnection():Unit={
    mongoClient.close()
  }
}
