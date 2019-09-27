package Day4

object Lumberjack extends App{
   import scala.io.StdIn
  println("=============================\nGrid size:")
  val gridSize:Int=getMeAnIntOrElse(3)
  println("=============================\nNumber of Logs:")
  val numberOfLogs:Int=getMeAnIntOrElse(7)
  val grid = getGrid()
  (1 to numberOfLogs).foreach(_ => grid.update(minIndex()._1, minIndex()._2))
  printGrid()

  def getGrid():Array[Int]={
    val tempGrid = Array.ofDim[Int](gridSize, gridSize)
    println("Current arrangement of grid:")
    for(i <- 0 until gridSize) {
      val line = StdIn.readLine().trim.split("[,\\s+]")
      for(j <- 0 until math.min(gridSize,line.length)) tempGrid(i)(j) = Integer.parseInt(line(j))
    }
    tempGrid.flatten
  }

  def getMeAnIntOrElse(_else:Int):Int={
    StdIn.readLine().replaceAll("[^\\s+\\d+]", "").split("[\\s+]")
      .map(str => str=="" match {
        case false => Some(Integer.parseInt(str))
        case _ => None
      }).head.getOrElse(_else)
  }

  def minIndex():(Int, Int)={
    val minimum = grid.min
    val flatIndex = grid.indexOf(minimum)
    (flatIndex, minimum+1)
  }

  def printGrid()={
    for{
      i <- 0 until gridSize*gridSize by gridSize
      j <- 0 until gridSize
      k = j match {case 0 => "\n"; case _ =>""}
    }
    print(s"$k${grid(i+j)} ")
  }

}
