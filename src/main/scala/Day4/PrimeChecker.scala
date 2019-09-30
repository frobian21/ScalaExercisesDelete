package Day4

object PrimeChecker extends App {
  import scala.collection.immutable.{ListMap, Map}
  var lowerLimit = 1000001
  val upperLimit = 3000000
  val maxNumberToCheck = List.range(3,upperLimit,2).filter(number => number * number > upperLimit).head
  var numberMap= Map[Int, Boolean]((3 to upperLimit by 2).toArray.zipAll(List(false), 0, false): _*)

  for{
    x <- 1 to upperLimit by 2 if x<maxNumberToCheck
    y <- 1 to upperLimit by 2 if y<maxNumberToCheck
  }{
    // Main part of Sieve of Atkin
    var n = (4 * x * x) + (y * y);
    if (n <= upperLimit && (n % 12 == 1 || n % 12 == 5))

      numberMap = numberMap + (n -> true)

    n = (3 * x * x) + (y * y);
    if (n <= upperLimit && n % 12 == 7)
      numberMap = numberMap + (n -> true)

    n = (3 * x * x) - (y * y);
    if (x > y && n <= upperLimit && n % 12 == 11)
      numberMap = numberMap + (n -> true)
  }
  for(x <- lowerLimit to upperLimit by 2){
    if(numberMap(x)==true) println(x)
  }
}