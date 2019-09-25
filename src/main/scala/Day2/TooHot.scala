package Day2

object TooHot extends App{
  def checkTemperature(temperature: Int, isSummer: Boolean): Boolean =
    (temperature, isSummer) match {
      case (temp, false) => temp>=60 && temp<=90
      case (temp, true) => temp>=60 && temp<=100
    }
  println(s"checkTemperature(80,false) is ${checkTemperature(80,false)}")
  println(s"checkTemperature(100,false) is ${checkTemperature(100,false)}")
  println(s"checkTemperature(100,true) is ${checkTemperature(100,true)}")
}
