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
        //filtering input, not necessary.
      input.map(println(_))
      println("================\nLongest word(s):")
      //time it
      input.map(time{filterWordList(_)})
    } catch {
      case e: Error => println(e)
      case _ => println("Something went wrong")
    }
  }
  def filterWordList(str: String)={
    println(wordList.filter(_ matches s"([$str]+)").foldLeft("")((a: String, b: String) =>{if(a.length > b.length) a else b}))
    println(wordList.filter(_.toSet == str.toSet).foldLeft("")((a: String, b: String) =>{if(a.length > b.length) a else b}))
  }
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }
  lineReader()
}