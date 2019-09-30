val limit = 100
for {
  x <- 1 to limit
  y <- 1 to limit by 2
  n = (4 * x * x) + (y * y)
  if n < limit
}
  println(x,y, n)