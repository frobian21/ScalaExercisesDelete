package Day5

import resources.BaseTestingClass

class CalculatorTest extends BaseTestingClass{
  val calculator = new Calculator()
  test("Make a calculator instance"){
    assert(calculator.isInstanceOf[Calculator]==true)
  }
  test("Use calculator to return sum of two integers"){
    assert(calculator.sum(10, 2) == 12)
    assert(calculator.sum(12, 2) == 14)
  }
  test("Use calculator to return difference of two integers"){
    assert(calculator.subtract(10,8)==2)
    assert(calculator.subtract(8,10)==(-2))
  }
  test("Use calculator to return multiple of two integers"){
    assert(calculator.multiply(10,8)==80)
    assert(calculator.multiply(8,10)==80)
    assert(calculator.multiply(7,5)==35)
  }

  test("Use calculator to return division of two integers"){
    assert(calculator.divide(10,5)==2)
    assert(calculator.divide(5, 10)==0.5)
  }
  test("Use calculator to return sum of two doubles"){
    assert(calculator.sum(10.0, 2.0) == 12.0)
    assert(calculator.sum(12.1, 2.0) == 14.1)
  }
  test("Use calculator to return difference of two doubles"){
    assert(calculator.subtract(10.3,8.2)==2.1)
    assert(calculator.subtract(8.2,10.3)==(-2.1))
  }

  test("Use calculator to return multiple of two doubles"){
    assert(calculator.multiply(10.0,8.5)==85.0)
    assert(calculator.multiply(8.3,10.0)==83)
    assert(calculator.multiply(7,5.05)==35.35)
  }

  test("Use calculator to return division of two doubles") {
    assert(calculator.divide(10.5, 5.0) == 2.1)
    assert(calculator.divide(5.1, 10.0) == 0.51)
  }

  test("Use calculator to return sum of negative integers"){
    assert(calculator.sum(-10, -2) == -12)
    assert(calculator.sum(-12, 2) == -10)
  }

  test("Use calculator to return division of 0") {
    assert(calculator.divide(10, 0) == 0)
  }
}
