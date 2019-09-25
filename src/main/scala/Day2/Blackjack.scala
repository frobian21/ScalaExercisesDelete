package Day2

object Blackjack extends App{
  def winningHand(handA: Int, handB: Int): Int = {
    val handABust=handA>21
    val handBBust=handB>21
    (handA, handB) match {
      case _ if handABust && handBBust => 0
      case _ if handABust => handB
      case _ if handBBust => handA
      case _ if handA>handB => handA
      case _ => handB
    }
  }
  println(winningHand(18, 21))
  println(winningHand(20, 18))
  println(winningHand(22, 22))
}
