package Day2

object BrokenKeyboard extends App{
  import scala.io.Source
  val wordList = Source.fromURL("http://norvig.com/ngrams/enable1.txt").mkString.split("\n").toList
  //println(wordList(1))
  def lineReader(): Unit ={
    println("Give number of lines to read:")
    val linesToRead=scala.io.StdIn.readInt()
    val input = new Array[String](linesToRead)
    for (i <- 0 until linesToRead) input(i)=scala.io.StdIn.readLine()
    println(s"Successfully read $linesToRead lines")
    for (i <- 0 until linesToRead) filterWordList(input(i))
  }
  def filterWordList(str: String)={
    println(wordList.filter{s => s matches s"([$str]+)"}.foldLeft("")((a: String, b: String) =>{if(a.length > b.length) a else b}))
  }
  lineReader()
}
