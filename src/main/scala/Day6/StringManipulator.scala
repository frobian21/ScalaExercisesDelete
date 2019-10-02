package Day6

import scala.annotation.tailrec

class StringManipulator {
  def longestSubSequence(string1:String, string2:String, subsequence:String=""):String={
    val str1 = string1.toLowerCase
    val str2 = string2.toLowerCase
    (str1, str2, subsequence) match {
      case _ if str1.length == 0 || str2.length == 0 => subsequence
      case _ if str1.takeRight(1)==str2.takeRight(1) => longestSubSequence(str1.dropRight(1),str2.dropRight(1),str2.takeRight(1)+subsequence)
      case _ =>
        val substring1 = longestSubSequence(str1, str2.dropRight(1), subsequence)
        val substring2 = longestSubSequence(str1.dropRight(1), str2, subsequence)
        if (substring1.length > substring2.length) substring1
        else substring2
    }
  }
  def shortestTransform(string1:String, string2:String):String= {
    val substring = longestSubSequence(string1, string2)

    def deletions(string1CharFromRight: Int = 1, substringCharFromRight: Int = 1, output: String = ""): String = {
      if (string1CharFromRight > string1.length) output
      else if (substringCharFromRight > substring.length || string1.charAt(string1.length - string1CharFromRight) != substring.charAt(substring.length - substringCharFromRight))
        deletions(string1CharFromRight + 1, substringCharFromRight, output + s"Del(${string1.charAt(string1.length - string1CharFromRight)},${string1.length - string1CharFromRight}), ")
      else deletions(string1CharFromRight + 1, substringCharFromRight + 1, output)
    }

    def insertions(substringCharAt: Int = 0, string2CharAt: Int = 0, output: String = ""): String = {
      if (string2CharAt == string2.length) output
      else if (substringCharAt==substring.length || string2.charAt(string2CharAt) != substring.charAt(substringCharAt))
        insertions(substringCharAt, string2CharAt + 1, output + s"Ins(${string2.charAt(string2CharAt)},$string2CharAt), ")
      else insertions(substringCharAt + 1, string2CharAt + 1, output)
    }
    (deletions() + insertions()).dropRight(2)
  }

}
