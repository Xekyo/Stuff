/**
  * Created by murch on 24.03.17.
  */
object GreatestSumOfSubsequence {

  def gSoS(setOfInt:List[Int]) : Int = {
    var localBest : Int = 0
    var bestSetSum : Int = 0

    for (i <- 0 until setOfInt.size) {
      localBest = math.max(localBest + setOfInt(i), setOfInt(i))
      bestSetSum = math.max(bestSetSum, localBest)
    }

    return bestSetSum
  }
}
