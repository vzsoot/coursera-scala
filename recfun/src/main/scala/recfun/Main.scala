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
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0)
      0
    else if (c == 0 && r == 0)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }                                               //> pascal: (c: Int, r: Int)Int

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def stack(chars: List[Char]): Int = {
      if (chars.isEmpty)
        0
      else if (chars.head=='(')
      	1+stack(chars.tail)
      else if (chars.head==')')
      	-1+stack(chars.tail)
      else
        stack(chars.tail)
    }
    
    stack(chars)==0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    val coinsSorted = coins.sortWith((x, y) => { x <= y })
    val coinsMax = coinsSorted.map((x) => { money / x })
    val coinsMaxSum = coinsMax.sum;

    def incr(list: List[Int], max: List[Int]): (List[Int], Int) = {
      if (list.length == 1)
        if (list.last == max.last)
          (List(0), 1)
        else
          (List(list.last + 1), 0)
      else {
        val incrList = incr(list.init, max.init)
        if (list.last + incrList._2 > max.last)
          (incrList._1 :+ 0, 1)
        else
          (incrList._1 :+ (list.last + incrList._2), 0)
      }
    }

    def counter(multi: List[Int], solution: Int): Int = {
      val sum = (coinsSorted zip multi).map((x) => { x._1 * x._2 }).sum
      if (multi.sum >= coinsMaxSum)
        solution
      else {
        counter(incr(multi, coinsMax)._1, solution + (if (sum == money) 1 else 0))
      }
    }

    counter(coinsMax.head +: List.fill(coins.length - 1)(0), 0)
  } //> countChange: (money: Int, coins: List[Int])Int
}
