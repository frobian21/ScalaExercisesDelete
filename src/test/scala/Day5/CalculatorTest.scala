package Day5

import resources.BaseTestingClass

class CalculatorTest extends BaseTestingClass{
  val calculator = new Calculator()
  test("Make a calculator instance"){
    assert(calculator.isInstanceOf[Calculator]==true)
  }
  test("Use calculator to return sum of two numbers"){
    assert(calculator.sum(10, 2) == 12)
    assert(calculator.sum(12, 2) == 14)
  }
  test("Use calculator to return difference of two numbers"){
    assert(calculator.subtract(10,8)==2)
    assert(calculator.subtract(8,10)==(-2))
  }
  test("Use calculator to return multiple of two numbers"){
    assert(calculator.multiply(10,8)==80)
    assert(calculator.multiply(8,10)==80)
    assert(calculator.multiply(7,5)==35)
  }

  test("Use calculator to return division of two numbers"){
    assert(calculator.divide(10,5)==2)
    assert(calculator.divide(5, 10)==0.5)
  }

}
