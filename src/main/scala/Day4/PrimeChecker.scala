//package Day4
//
//object PrimeChecker extends App {
//  var lowerLimit = 1000001
//  val upperLimit = 3000000
//  val maxNumberToCheck = List.range(3,upperLimit,2).filter(number => number * number > upperLimit).head
//  val numberList = List.range(3,upperLimit,2)
//
//
//  for{
//    x <- 1 to upperLimit if x<maxNumberToCheck
//    y <- 1 to upperLimit if y<maxNumberToCheck
//  }{
//    // Main part of Sieve of Atkin
//    var n = (4 * x * x) + (y * y);
//    if (n <= upperLimit && (n % 12 == 1 || n % 12 == 5))
//
//      numberList
//
//    n = (3 * x * x) + (y * y);
//    if (n <= upperLimit && n % 12 == 7)
//      sieve[n] ^= true;
//
//    n = (3 * x * x) - (y * y);
//    if (x > y && n <= upperLimit && n % 12 == 11)
//      sieve[n] ^= true;
//  }
//}