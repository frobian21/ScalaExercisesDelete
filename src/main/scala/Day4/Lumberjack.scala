package Day4

object Lumberjack extends App{
   import scala.io.StdIn
  println("=============================\nGrid size:")
  val gridSize:Int=getMeAnIntOrElse(3)
  println("=============================\nNumber of Logs:")
  val numberOfLogs:Int=getMeAnIntOrElse(7)
  val grid = Array.ofDim[Int](gridSize, gridSize)
  println("Current arrangement of grid:")
  for(i <- 0 until grid.length) {
    val line = StdIn.readLine().trim.split("[,\\s+]")
    for(j <- 0 until math.min(grid.length,line.length)) grid(i)(j) = Integer.parseInt(line(j))
  }
  (1 to numberOfLogs).foreach(_ => grid(minIndex()._1).update(minIndex()._2, minIndex()._3))
  printGrid(grid)

  def getMeAnIntOrElse(_else:Int):Int={
    StdIn.readLine().replaceAll("[^\\s+\\d+]", "").split("[\\s+]")
      .map(str => str=="" match {
        case false => Some(Integer.parseInt(str))
        case _ => None
      }).head.getOrElse(_else)
  }

  def minIndex():(Int, Int, Int)={
    val minimum = grid.flatten.min
    val flatIndex = grid.flatten.indexOf(minimum)
    (flatIndex/gridSize, flatIndex%gridSize, minimum+1)
  }

  def printGrid(grid: Array[Array[Int]])={
    for(i <- 0 until grid.length) {
      grid(i).foreach(str => print(s"$str "))
      print("\n")
    }
  }

}
