package Day1

object TypeInference extends App{
  def myMethod(input: Any) = input
  println(myMethod(1.0))
  println(myMethod("hello"))
  println(myMethod(1))
  println(myMethod(input = true))
}
