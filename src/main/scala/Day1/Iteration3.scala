package Day1

object Iteration3 extends App{
  def fizzBuzz(firstWord: String, secondWord: String, count: Int)={
    for(i<-1 to count){
      val aResult = i%3==0
      val bResult = i%5==0
      if(aResult && bResult) print(firstWord + secondWord + ",")
      else if(aResult) print(firstWord + ",")
      else if(bResult) print(secondWord + ",")
      else print(i.toString + ",")
    }
    print("\n")
  }
  fizzBuzz("Fizz", "Buzz", 15)

  def fizzBuzz2(firstWord: String, secondWord: String, count: Int)={
    val output = new StringBuilder("")
    for(i<-1 to count){
      val aResult = i%3==0
      val bResult = i%5==0
      if(aResult && bResult) output.append(firstWord + secondWord + ",")
      else if(aResult) output.append(firstWord + ",")
      else if(bResult) output.append(secondWord + ",")
      else output.append(i.toString + ",")
    }
    println(output)
  }
  fizzBuzz2("Fizz", "Buzz", 15)
}
