package Day1

object Strings2 extends App{
  def twoStringsTwoChars(str1: String, str2: String, chr1: Char, chr2: Char): String ={
    (str1+str2).replace(chr1, chr2)
  }
  println(twoStringsTwoChars("Hello my fri", "ends", 'e', 'a'))
}
