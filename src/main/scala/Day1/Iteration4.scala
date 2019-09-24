package Day1

import scala.annotation.tailrec

object Iteration4 extends App {

  def repeater(name: String, input: Int) = {

    @tailrec
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
      if(count%3==0 && count%5==0) print(word1+word2)
      else if(count%3==0) print(word1)
      else if(count%5==0) print(word2)
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
