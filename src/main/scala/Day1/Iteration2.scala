package Day1

object Iteration2 extends App{
  def squareRepeater(word: String, num: Int)= {
    for(i<-1 to num.abs) println(word.repeat(num))
  }
  println(squareRepeater("H", 4))
}
