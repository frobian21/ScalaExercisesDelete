package Day4

object CreditCard extends App{
  def calculateLuhnNumber(number:String):Int={
    number.toCharArray.map(_.getNumericValue).reverse.zipWithIndex.map(myTuple => myTuple._1.toInt*(myTuple._2%2+1))
      .map(num => num>9 match {
        case true => num-9
        case false => num
      }).sum.%(10)
  }
  def checkNumber(number:String): Boolean={
    calculateLuhnNumber(number)==0
  }
  def makeNumberLuhnNumber(number:String):String={
    var check = 0;
    while(check<10 && !checkNumber(number+check.toString)){
      check+=1
    }
    number+check.toString
  }
  val number = "4992739871"
  val number2 = number.concat("6")
  println(s"$number2 is valid Luhn number: ${checkNumber(number2)}")
  println(s"$number as valid Luhn number: ${makeNumberLuhnNumber(number)}")
}
