package Day6

import resources.BaseTestingClass

class StringManipulatorTest extends BaseTestingClass{
  val manipulator = new StringManipulator
  test("Longest substring of hello and hell"){
    assert(manipulator.longestSubSequence("hello", "hell") == "hell")
  }
  test("Longest substring of hello and he"){
    assert(manipulator.longestSubSequence("hello", "he")=="he")
  }
  test("Longest substring of hall and al"){
    assert(manipulator.longestSubSequence("ball", "halt")=="al")
  }
  test("shortest sequence to transform hello to hell"){
    assert(manipulator.shortestTransform("hello", "hell")=="Del(o,4)")
  }
  test("shortest sequence to transform hell to hello"){
    assert(manipulator.shortestTransform("hell", "hello")=="Ins(o,4)")
  }
  test("shortest sequence to transform hell to helm"){
    assert(manipulator.shortestTransform("hell", "helm")=="Del(l,2), Ins(m,3)")
  }
  test("shortest sequence to transform ell to helm"){
    assert(manipulator.shortestTransform("ell", "helm")=="Del(l,1), Ins(h,0), Ins(m,3)")
  }
  test("shortest sequence to transform football to stadium"){
    assert(manipulator.shortestTransform("football", "stadium")=="Del(l,7), Del(l,6), Del(b,4), Del(o,2), Del(o,1), Del(f,0), Ins(s,0), Ins(d,3), Ins(i,4), Ins(u,5), Ins(m,6)")
  }
}