package Day6

class LongestSubSequence {
  def longestSubSequence(string1:String, string2:String, subsequence:String=""):String={
    val str1 = string1.toLowerCase
    val str2 = string2.toLowerCase
    (str1, str2, subsequence) match {
      case _ if str1.length == 0 || str2.length == 0 => subsequence
      case _ if str1.takeRight(1)==str2.takeRight(1) => longestSubSequence(str1.dropRight(1),str2.dropRight(1),str2.takeRight(1)+subsequence)
      case _ => {
        val substring1 = longestSubSequence(str1, str2.dropRight(1), subsequence)
        val substring2 = longestSubSequence(str1.dropRight(1), str2, subsequence)
        if (substring1.length > substring2.length) substring1
        else substring2
      }
    }
  }
}
