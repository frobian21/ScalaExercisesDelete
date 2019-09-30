package Day4

object PrimeChecker extends App {
  import scala.collection.immutable.Map
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.util.{Failure, Success}

  val startTime = System.currentTimeMillis()
  val limit = 10000
  val lowerLimit = 1000
  // set of wheel "hit" positions for a 2/3/5 wheel rolled twice as per the Atkin algorithm
  val hitPositions = List(1,7,11,13,17,19,23,29,31,37,41,43,47,49,53,59)
  val hitPositionsAll = List.tabulate(limit/60+1)(num =>hitPositions.map(_+60*num)).flatMap(num => num)
//  var numberMap=Map[Int, Boolean](hitPositionsAll.toArray.zipAll(List(false), 0, false): _*)
  def addToSet(numberSet: Map[Int, Boolean], number:Int) = {
    if(numberSet.contains(number)) numberSet + (number -> !numberSet(number))
    else numberSet + (number -> true)
  }

  // Put in candidate primes:
  //   integers which have an odd number of
  //   representations by certain quadratic forms.
  // Main part of Sieve of Atkin
  // Algorithm step 3.1:
  val step1 = Future {
    println("Step 1")
    var numberSet = scala.collection.immutable.Map[Int, Boolean]()
    for {
      x <- 1 to limit
      y <- 1 to limit by 2
      n = (4 * x * x) + (y * y)
      if n < limit
      if Set(1, 13, 17, 29, 37, 41, 49, 53) contains (n % 60)
    } numberSet = addToSet(numberSet, n)
    numberSet
  }
//   Algorithm step 3.2:
  val step2 = Future {
    println("Step 2")
    var numberSet = scala.collection.immutable.Map[Int, Boolean]()
    for {
      x <- 1 to limit by 2
      y <- 2 to limit by 2
      n = (3 * x * x) + (y * y)
      if n < limit
      if Set(7, 19, 31, 43) contains (n % 60)
    } numberSet = addToSet(numberSet, n)
    numberSet
  }
  // Algorithm step 3.3:
  val step3 = Future {
    println("Step 3")
    var numberSet = scala.collection.immutable.Map[Int, Boolean]()
    for {
      x <- 2 to limit
      y <- x - 1 to 1 by -2
      n = (3 * x * x) - (y * y)
      if n < limit
      if Set(11, 23, 47, 59) contains (n % 60)
    } numberSet = addToSet(numberSet, n)
    numberSet
  }
  // (b) run futures simultaneously
  val result = for{
    result1 <- step1
    result2 <- step2
    result3 <- step3
  } yield result1 ++ result2 ++ result3
  // Eliminate composites by sieving, only for those occurrences on the wheel:
  var outputMap = scala.collection.immutable.Map[Int, Boolean]()
  result.onComplete {
    case Success(numberMap) =>
      outputMap = numberMap
      hitPositionsAll.foreach{
        case n if n >= 7 && n * n < limit =>{
          val tempMap=hitPositionsAll.map(_*n * n )
          for {
            c <- tempMap
            if c <= limit
            if outputMap.contains(c)
          } outputMap = outputMap + (c -> false)
        }
      case _ => outputMap = outputMap
      }
      for(n<-lowerLimit to limit){
        if(outputMap.contains(n) && outputMap(n)) println(n)
      }
      println(outputMap.filter(_._1 > lowerLimit).filter(_._1 < limit).filter(_._2==true).size)
      val endTime = System.currentTimeMillis()
      println("Elapsed time: " + (endTime - startTime) + "ms")
    case Failure(e) => e.printStackTrace()
  }

  sleep(5*60*1000)

  def sleep(time: Long): Unit = Thread.sleep(time)
}