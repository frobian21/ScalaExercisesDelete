package Day4

object Lumberjack extends App{
   import scala.io.StdIn
  println("=============================\nGrid size:")
  val gridSize:Int=StdIn.readLine().replaceAll("[^\\s+\\d+]", "").split("[\\s+]")
    .map(str => str=="" match {
      case false => Some(Integer.parseInt(str))
      case _ => None
    }).head.getOrElse(3)
  println("=============================\nNumber of Logs:")
  val numberOfLogs:Int=StdIn.readLine().replaceAll("[^\\s+\\d+]", "").split("[\\s+]")
    .map(str => str=="" match {
      case false => Some(Integer.parseInt(str))
      case _ => None
    }).head.getOrElse(7)
  val grid = Array.ofDim[Int](gridSize, gridSize)
  println("Current arrangement of grid:")
  for(i <- 0 until gridSize) {
    val line = StdIn.readLine().trim.split("[,\\s+]")
    for(j <- 0 until math.min(gridSize,line.length)) grid(i)(j) = Integer.parseInt(line(j))
  }
  (1 to numberOfLogs).foreach(_ => grid(minIndex()._1).update(minIndex()._2, minIndex()._3))
  printGrid(gridSize,grid)

  def minIndex():(Int, Int, Int)={
    val minimum = grid.flatten.min
    val flatIndex = grid.flatten.indexOf(minimum)
    (flatIndex/gridSize, flatIndex%gridSize, minimum+1)
  }

  def printGrid(gridSize: Int, grid: Array[Array[Int]])={
    for(i <- 0 until gridSize) {
      grid(i).foreach(str => print(s"$str "))
      print("\n")
//    for (j <- 0 until gridSize) print(s"${grid(i)(j)} ")
//    print("\n")
    }
  }

}
