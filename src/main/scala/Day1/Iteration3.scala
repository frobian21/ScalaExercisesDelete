package Day1

object Iteration3 extends App{
  def fizzBuzz(firstWord: String, secondWord: String, count: Int)={
    var output = ""
    for(i<-1 to count){
      if(i%3==0 && i%5==0) output += firstWord + secondWord + ","
      else if(i%3==0) output += firstWord + ","
      else if(i%5==0) output += secondWord + ","
      else output += i.toString + ","
    }
    println(output)
  }
  fizzBuzz("Fizz", "Buzz", 15)
   def fizzBuzz2(firstWord: String, secondWord: String, count: Int)={
    var output = new StringBuilder("")
    for(i<-1 to count){
      if(i%3==0 && i%5==0) output.append(firstWord + secondWord + ",")
      else if(i%3==0) output.append(firstWord + ",")
      else if(i%5==0) output.append(secondWord + ",")
      else output.append(i.toString + ",")
    }
    println(output)
  }
  fizzBuzz2("Fizz", "Buzz", 15)
}
