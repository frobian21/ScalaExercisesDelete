package Day1

import scala.annotation.tailrec

object Iteration4 extends App {

  def repeater(name: String, input: Int) = {
    @annotation.tailrec
    def repeaterRec(name: String, end: Int, count: Int = 1): Unit = {
      println(name)
      if(count<end)
        repeaterRec(name, end, count+1)
    }
    repeaterRec(name, input.abs)
  }

  def squareRepeater(name: String, count: Int) ={
    @tailrec
    def squareRepeaterRec(name: String, end: Int, count: Int = 1):Unit = {
      println(name.repeat(end))
      if(count<end)
        squareRepeaterRec(name, end, count+1)
    }
    squareRepeaterRec(name, count)
  }

  def fizzBuzz(word1: String, word2: String, count: Int): Unit ={
    @tailrec
    def fizzBuzzRec(word1: String, word2: String, end: Int, count: Int = 1): Unit ={
      val firstCase = count%3==0; val secondCase = count%5==0
      if(firstCase && secondCase) print(word1+word2)
      else if(firstCase) print(word1)
      else if(secondCase) print(word2)
      else print(count)
      if(count<end) {
        print(",")
        fizzBuzzRec(word1, word2, end, count+1)
      }
    }
    fizzBuzzRec(word1, word2, count)
  }

  repeater("He",2)
  squareRepeater("he", 4)
  fizzBuzz("Fizz", "Buzz", 15)
}
