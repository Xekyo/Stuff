import org.scalatest.FunSuite

/**
  * Created by murch on 24.03.17.
  */
class GreatestSumOfSubsequence$Test extends FunSuite {
  test("Empty list returns 0") {
    assert(GreatestSumOfSubsequence.gSoS(List[Int]()) === 0)
  }

  test("Single Positive returns itself") {
    assert(GreatestSumOfSubsequence.gSoS(List[Int](4)) === 4)
  }

  test("List of Positives returns sum") {
    assert(GreatestSumOfSubsequence.gSoS(List[Int](1,2,3,4)) === 10)
  }

  test("List of negatives returns 0 (empty sum)") {
    assert(GreatestSumOfSubsequence.gSoS(List[Int](-1,-2,-3,-4)) === 0)
  }

  test("Bridge negatives for maximum result") {
    assert(GreatestSumOfSubsequence.gSoS(List[Int](-1,4,-3,4)) === 5)
  }

  test("Don't include negatives when detrimental") {
    assert(GreatestSumOfSubsequence.gSoS(List[Int](10,-4,3,-2)) === 10)
  }

  test("Find suffix chain") {
    assert(GreatestSumOfSubsequence.gSoS(List[Int](1,2,3,4,-11,6,7)) === 13)
  }

  test("Sum of Fibonacci numbers") {
    lazy val fibonacciNumbers: Stream[Int] = 0 #:: fibonacciNumbers.scanLeft(1)(_ + _)
    val firstTen = fibonacciNumbers.take(10).toList
    assert(GreatestSumOfSubsequence.gSoS(firstTen) > 42)
  }
}
