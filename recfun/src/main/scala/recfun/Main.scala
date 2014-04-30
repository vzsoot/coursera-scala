package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = ???

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = ???

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def doCount(usedCoins: List[Int], nextCoin: Int): Int = {
      val coinsSum = usedCoins.sum + coins(nextCoin)
      if (coinsSum == money)
        if (!usedCoins.isEmpty && nextCoin < coins.length - 1)
          1 + doCount(usedCoins.init, nextCoin + 1)
        else if (usedCoins.isEmpty && nextCoin < coins.length - 1)
          1 + doCount(usedCoins, nextCoin + 1)
        else if (!usedCoins.isEmpty && nextCoin == coins.length - 1)
          1 + doCount(usedCoins.init, nextCoin)
        else
          1
      else if (coinsSum < money)
        doCount(usedCoins :+ coins(nextCoin), nextCoin)
      else if (coinsSum > money && !usedCoins.isEmpty && nextCoin < coins.length - 1)
        doCount(usedCoins.init, nextCoin + 1)
      else
        0
    }

    doCount(List.empty[Int], 0)
  } //> countChange: (money: Int, coins: List[Int])Int

}
