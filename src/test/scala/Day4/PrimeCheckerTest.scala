package Day4

import resources.BaseTestingClass

class PrimeCheckerTest extends BaseTestingClass{
  val primeChecker = new PrimeChecker
  test("Number of primes between 100 and 1000"){
    assert(primeChecker.ListPrimeChecker(100, 1000) == 168-25)
  }
  test("Number of primes between 1000 and 10000"){
    assert(primeChecker.ListPrimeChecker(1000,10000) == 1229-168)
  }
  test("Number of primes between 10000 and 100000"){
    assert(primeChecker.ListPrimeChecker(10000,100000) == 9592-1229)
  }
  test("Number of primes between 100000 and 1000000"){
    assert(primeChecker.ListPrimeChecker(100000,1000000) == 78498-9592)
  }
  test("Number of primes between 1000000 and 3000000"){
    assert(primeChecker.ListPrimeChecker(1000000,3000000) == 216816-78498)
  }
}
