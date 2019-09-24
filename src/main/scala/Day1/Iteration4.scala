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

  repeater("He",2)
}
