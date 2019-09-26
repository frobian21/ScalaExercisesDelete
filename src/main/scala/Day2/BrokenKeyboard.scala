package Day2

object BrokenKeyboard extends App{
  import scala.io.Source
  val wordList = Source.fromURL("http://norvig.com/ngrams/enable1.txt").mkString.split("\n").toList
  def lineReader(): Unit ={
    try{
      println("=============================\nGive number of lines to read:")
      val linesToRead=scala.io.StdIn.readInt()
      val input = new Array[String](linesToRead)
      for (i <- 0 until linesToRead) input(i)=scala.io.StdIn.readLine()
        .replaceAll("[^a-zA-Z]","").toLowerCase()
        //filtering input, not necessary.
      //time it
      input.map(time{filterWordList(_)})
    } catch {
      case e: Error => println(e)
      case _ => println("Something went wrong")
    }
  }
  def filterWordList(str: String)={
    println("===============")
    println(s"String is $str")
    println("Longest word:")
    println(wordList.filter(_ matches s"([$str]+)")
      .foldLeft("")((longestWord: String, possibleNewLongestWord: String) =>{
        if(longestWord.length > possibleNewLongestWord.length) longestWord else possibleNewLongestWord
      }))
    println("Longest word containg all the characters:")
    println(wordList.filter(_.toSet == str.toSet)
      .foldLeft("")((longestWord: String, possibleNewLongestWord: String) =>{
        if(longestWord.length > possibleNewLongestWord.length) longestWord else possibleNewLongestWord
      }))
  }
  def time[R](block: => R): R = {
    val startTime = System.nanoTime()
    val result = block    // call-by-name
    val endTime = System.nanoTime()
    println("Elapsed time: " + (endTime - startTime) + "ns")
    result
  }
  lineReader()
}