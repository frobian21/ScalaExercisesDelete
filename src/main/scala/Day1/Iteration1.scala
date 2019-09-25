package Day1

object Iteration1 extends App{
  def repeater(word: String, num: Int) = {
    for(i<-0 until num.abs) println(word)
  }
  repeater("Hey", 5)
}
