package Day6

import resources.BaseTestingClass

class StringManipulatorTest extends BaseTestingClass{
  val manipulator = new StringManipulator
  test("Longest substring of hello and hell"){
    assert(manipulator.longestSubSequence("hello", "hell").equals("hell"))
  }
  test("Longest substring of hello and he"){
    assert(manipulator.longestSubSequence("hello", "he").equals("he"))
  }
  test("Longest substring of hello and hl"){
    assert(manipulator.longestSubSequence("hello", "halt").equals("hl"))
  }
  test("shortest sequence to transform hello to hell"){
    assert(manipulator.shortestTransform("hello", "hell").equals("Del(o,5)"))
  }
  test("shortest sequence to transform hell to hello"){
    assert(manipulator.shortestTransform("hell", "hello").equals("Ins(m,5)"))
  }
  test("shortest sequence to transform hell to helm"){
    assert(manipulator.shortestTransform("hell", "helm").equals("Del(l,4), Ins(m,4)"))
  }
}
