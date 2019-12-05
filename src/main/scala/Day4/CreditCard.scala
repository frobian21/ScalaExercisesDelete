package Day4

import scala.annotation.tailrec

object CreditCard extends App{
  def calculateLuhnNumber(number:String):Int={
    number.toCharArray.map(_.getNumericValue).reverse.zipWithIndex.map(myTuple => myTuple._1.toInt*(myTuple._2%2+1))
      .map(num => if (num > 9) num - 9 else num).sum.%(10)
  }
  def checkNumber(number:String): Boolean={
    calculateLuhnNumber(number)==0
  }
  @tailrec
  def makeNumberLuhnNumber(number:String, check:Int = 0):String={
    if(!checkNumber(number+check.toString)) makeNumberLuhnNumber(number, check+1)
    else number+check.toString
  }
  val number = "4992739871"
  val number2 = number.concat("6")
  println(s"$number2 is valid Luhn number: ${checkNumber(number2)}")
  println(s"$number as valid Luhn number: ${makeNumberLuhnNumber(number)}")
}
