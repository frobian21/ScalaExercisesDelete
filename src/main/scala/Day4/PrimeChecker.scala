package Day4

object PrimeChecker extends App {
  import scala.collection.immutable.Map
  val limit = 3000000
  val lowerLimit = 1000000
  // set of wheel "hit" positions for a 2/3/5 wheel rolled twice as per the Atkin algorithm
  val hitPositions = List(1,7,11,13,17,19,23,29,31,37,41,43,47,49,53,59)
  val hitPositionsAll = List.tabulate(limit/60+1)(num =>hitPositions.map(_+60*num)).flatMap(num => num)
  var numberMap=Map[Int, Boolean](hitPositionsAll.toArray.zipAll(List(false), 0, false): _*)


  // Put in candidate primes:
  //   integers which have an odd number of
  //   representations by certain quadratic forms.
  // Main part of Sieve of Atkin
  // Algorithm step 3.1:
  println("Step 1")
  for{
    x <- 1 to limit
    y <- 1 to limit by 2
    n = (4 * x * x) + (y * y)
    if n<limit
    if Set(1, 13, 17, 29, 37, 41, 49, 53) contains (n % 60)
    if numberMap.contains(n)
  } numberMap = numberMap + (n -> !numberMap(n))
  // Algorithm step 3.2:
//  println("Step 2")
//  for{
//    x <- 1 to limit by 2
//    y <- 2 to limit by 2
//    n = (3 * x * x) + (y * y)
//    if n<limit
//    if Set(7, 19, 31, 43) contains (n % 60)
//    if numberMap.contains(n)
//  } numberMap = numberMap + (n -> !numberMap(n))
//  // Algorithm step 3.3:
//  println("Step 3")
//  for{
//    x <- 1 to limit by 2
//    y <- x-1 to 1 by 2
//    n = (3 * x * x) - (y * y)
//    if n<limit
//    if Set(11, 23, 47, 59) contains (n % 60)
//    if numberMap.contains(n)
//  } numberMap = numberMap + (n -> !numberMap(n))
//  // Eliminate composites by sieving, only for those occurrences on the wheel:
//  hitPositionsAll.map({ case n if (n >= 7 && n * n < limit) && numberMap(n) =>
//    for {
//      c <- hitPositionsAll.map(_*n * n )
//      if c <= limit
//      if numberMap.contains(c)
//    } {
//      numberMap = numberMap + (c -> false)
//    }
//  })
  for(n<-lowerLimit to limit){
    if(numberMap.contains(n) && numberMap(n)) println(n)
  }
}