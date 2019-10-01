package Day6

import resources.BaseTestingClass

class LongestSubSequenceTest extends BaseTestingClass{
  val longestSub = new LongestSubSequence
  test("Longest substring of hello and he"){
    assert(longestSub.longestSubSequence("hello", "he").equals("he"))
  }
  test("Longest substring of hello and hell"){
    assert(longestSub.longestSubSequence("hello", "hell").equals("hell"))
  }
  test("Longest substring of hello and hl"){
    assert(longestSub.longestSubSequence("hello", "halt").equals("hl"))
  }
}
