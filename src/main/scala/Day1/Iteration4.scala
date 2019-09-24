package Day1

import scala.annotation.tailrec

object Iteration4 extends App {


  def repeater(name: String, input: Int) = {

    @tailrec
    def repeaterRec(name: String, end: Int, count: Int): Unit = {
      println(name)
      if(count<end)
        repeaterRec(name, end, count+1)
    }

    repeaterRec(name, input.abs, 1)
  }

  def squareRepeater(name: String, count: Int) ={

    @tailrec
    def squareRepeaterRec(name: String, end: Int, count: Int):Unit = {
      println(name.repeat(end))
      if(count<end)
        squareRepeaterRec(name, end, count+1)
    }

    squareRepeaterRec(name, count, 1)
  }
  repeater("He",2)
  squareRepeater("he", 4)
}
