package Day2

object BrokenKeyboard extends App{
  import scala.io.Source
  val wordList = Source.fromURL("http://norvig.com/ngrams/enable1.txt").mkString.split("\n").toList
  //println(wordList(1))
  def lineReader(): Unit ={
    try{
    println("=============================\nGive number of lines to read:")
    val linesToRead=scala.io.StdIn.readInt()
    val input = new Array[String](linesToRead)
    for (i <- 0 until linesToRead) input(i)=scala.io.StdIn.readLine().replaceAll("[^a-zA-Z]","").toLowerCase()
    input.map(println(_))
    println("================\nLongest word(s):")
      input.map(filterWordList(_))
    } catch {
      case e: Error => println(e)
      case _ => println("Something went wrong")
    }
  }
  def filterWordList(str: String)={
    println(wordList.filter(_ matches s"([$str]+)").foldLeft("")((a: String, b: String) =>{if(a.length > b.length) a else b}))
  }
  lineReader()
}
