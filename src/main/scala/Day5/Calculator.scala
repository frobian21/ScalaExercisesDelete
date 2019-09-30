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
  def multiply[T](num1:T, num2:T)(implicit n:Numeric[T])= {
    import n._
    (math rint  (num1 * num2).toDouble * 1000) / 1000
  }
  def divide[T](num1:T, num2:T)(implicit n:Numeric[T])= {
    import n._
    if(num2 != 0) (math rint  (num1.toDouble / num2.toDouble) * 1000) / 1000
  }
}
