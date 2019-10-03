package Garage

import org.mongodb.scala._

class DBConnection {
  def getClient(url:String = "mongodb://localhost"):MongoClient={
    MongoClient(url)
  }
  def getDatabase(mongoClient: MongoClient, database_name:String):MongoDatabase ={
    mongoClient.getDatabase(database_name)
  }
  def getCollection(mongoDatabase: MongoDatabase, collectionName:String):MongoCollection[Document]={
    mongoDatabase.getCollection(collectionName)
  }
  def closeConnection(mongoClient: MongoClient):Unit={
    mongoClient.close()
  }
}
