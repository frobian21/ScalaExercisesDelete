package Day5

class Calculator {
  def sum[T](num1:T, num2:T)(implicit n:Numeric[T])={
    import n._
    num1 + num2
  }
  def subtract[T](num1:T, num2:T)(implicit n:Numeric[T])= {
    import n._
    (math rint  (num1 - num2).toDouble * 1000) / 1000
  }
  def multiply(num1:Int, num2:Int):Int= {
    num1*num2
  }
  def divide(num1:Int, num2:Int):Double= {
    num1.toDouble/num2
  }
}
