
def getNextInt(nextInt:Int):Int ={
  if (Set(1,7,11,13,17,19,23,29,31,37,41,43,47,49,53,59) contains nextInt%60) nextInt
  else getNextInt(nextInt+2)
}
getNextInt(17)