package Day1

object Strings extends App{
  def acceptOneStringAndOneInteger(str: String,  num: Int): String = str.takeRight(num)

  println(acceptOneStringAndOneInteger("hello my friends", 3))
}
