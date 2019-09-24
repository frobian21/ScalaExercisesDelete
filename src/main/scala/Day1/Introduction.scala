package Day1

object Introduction{
  /*
  var vs val -> var is mutable (for OOP), val is immutable (for functional) -> can't be reassigned
  function vs method -> method is dependent on object, function is static
  def - for methods, use parenthesis for method calls --> make it obvious for method call and not var call
  Naming convention: class MyFirstName, def myFirstName, val myFirstName
  to run code, either object that extends App or an object that has main method (use autofill)
  a+5 same as a.+(5)
  if only one argument, don't need to use parenthesis to call it
  && short-circuit & operator.
  a += 1, increment.
  println(raw"test \n line") removes formatting
  println(s"") or println(f"${2.009439040}%2.2f") -> f is morew advanced, can add decimal places
  list :+ append, list +: prepend
  */
  def main(args: Array[String]): Unit = {
    println("hey there")
    println(f"${2.009439040}%.2f")
    for(i <- 1 to 10 by 2) print(i+" ")
    print("\n")
    for(i <- 10 to 1 by -1) print(i+" ")
    print("\n")
    for(i <- 10 until 1 by -1) print(i+" ") //INCLUDE FINAL INDEX
    print("\n")
    for(i <- 1 to 5; j <- 1 to 3) print(s"($i,$j) ")
    print("\n")
    for (i <- 1 to 10
         if i>2
         if i<8
    ) println(i)
    for(i <- 1 to 3) yield(i) //can return values into example Vector(1,2,3)
    val a = for(i <- 1 to 5; j <- 1 to 3) yield (i, j)
    val b = a.toList
  }
}
