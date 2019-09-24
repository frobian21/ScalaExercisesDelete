package Day1

object Functional1 extends App{
  val b = java.util.TimeZone.getAvailableIDs().map(_.split("/"))
    .filter(elem => elem.size!=1)
    .map(_.last)
    .grouped(10)
    .foreach(elem => println(elem))
}
