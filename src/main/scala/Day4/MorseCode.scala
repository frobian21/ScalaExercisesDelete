package Day4

object MorseCode extends App{
  val morseCodeMap: Map[String, String] = Map(
    ".-" -> "A",
    "-..." -> "B",
    "-.-." -> "C",
    "-.." -> "D",
    "." -> "E",
    "..-." -> "F",
    "--." -> "G",
    "...." -> "H",
    ".." -> "I",
    ".---" -> "J",
    "-.-" -> "K",
    ".-.." -> "L",
    "--" -> "M",
    "-." -> "N",
    "---" -> "O",
    ".--." -> "P",
    "--.-" -> "Q",
    ".-." -> "R",
    "..." -> "S",
    "-" -> "T",
    "..-" -> "U",
    "...-" -> "V",
    ".--" -> "W",
    "-..-" -> "X",
    "-.--" -> "Y",
    "--.." -> "Z"
  ).withDefaultValue("")

  def morseStringToString(morse:String):String={
    morse.split("\\s/\\s").map(morseCodeMap).foldLeft("")(_+_)
  }

  def StringToMorseString(str: String):String={
    str.toCharArray.map(char => morseCodeMap.find(_._2==char.toString.toUpperCase).getOrElse("","")._1.concat(" / ")).foldLeft("")(_+_)
  }

  val morseString="..- / --.-"
  val string = "hello"
  println(s"$morseString is ${morseStringToString(morseString)}")
  println(s"$string is ${StringToMorseString(string)}")
  println(s"${StringToMorseString(string)} is ${morseStringToString(StringToMorseString(string))}")
}
