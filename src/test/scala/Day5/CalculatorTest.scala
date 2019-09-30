package Day5

import resources.BaseTestingClass

class CalculatorTest extends BaseTestingClass{
  test("Make a calculator instance"){
    val calculator = new Calculator()
    assert(calculator.isInstanceOf[Calculator]==true)
  }
  test("Return sum of two numbers with calculator"){
    val calculator = new Calculator()
    assert(calculator.sum(10, 2) == 12)
    assert(calculator.sum(12, 2) == 14)
  }
}
