package Day1

object Iteration3 extends App{
  def fizzBuzz(firstWord: String, secondWord: String, count: Int)={
    var output = ""
    for(i<-1 to count){
      var aResult = i%3==0
      var bResult = i%5==0
      if(aResult && bResult) output += firstWord + secondWord + ","
      else if(aResult) output += firstWord + ","
      else if(bResult) output += secondWord + ","
      else output += i.toString + ","
    }
    println(output)
  }
  fizzBuzz("Fizz", "Buzz", 15)

  def fizzBuzz2(firstWord: String, secondWord: String, count: Int)={
    var output = new StringBuilder("")
    for(i<-1 to count){
      var aResult = i%3==0
      var bResult = i%5==0
      if(aResult && bResult) output.append(firstWord + secondWord + ",")
      else if(aResult) output.append(firstWord + ",")
      else if(bResult) output.append(secondWord + ",")
      else output.append(i.toString + ",")
    }
    println(output)
  }
  fizzBuzz2("Fizz", "Buzz", 15)
}
