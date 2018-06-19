/** You are choreograhing a circus show with various animals. For one act, you are given two
  * kangaroos on a number line ready to jump in the positive direction (i.e, toward positive
  * infinity).
  *
  * The first kangaroo starts at location  and moves at a rate of  meters per jump.
  * The second kangaroo starts at location  and moves at a rate of  meters per jump.
  * You have to figure out a way to get both kangaroos at the same location as part of the show.
  *
  * Complete the function kangaroo which takes starting location and speed of both kangaroos as
  * input, and return  or  appropriately. Can you determine if the kangaroos will ever land at
  * the same location at the same time? The two kangaroos must land at the same location after
  * making the same number of jumps.
  *
  * Input Format
  * A single line of four space-separated integers denoting the respective
  * values of x1, v1, x2, and v2.
  */
import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {
    val YES: String = "YES"
    val NO: String = "NO"

    /** Geometry Problem: line intersection
      *
      * y = mx + b
      * y = x(n) * i + v(n)
      * v1 * i + x1 = v2 * i + x2
      * v1 * i = v2 * i + x2 - x1
      * v1 * i - v2 * i = x2 - x1
      * v1 - v2 = (x2 - x1) / s
      * (v1 - v2) / (x2 - x1) = 1 / s
      * s(v1 - v2) = (x2 - x1)
      * i = (x2 - x1) / (v1 - v2)
      *
      * if i is an integer, the kangaroos landed on the same space
      */
    def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String = {
        if (v1 < v2) {
            return NO
        }
        val intersect: Double = (x2 - x1).toDouble / (v1 - v2).toDouble
        if (intersect % 1 == 0) {
            return YES
        }

        return NO
    }

    def main(args: Array[String]) {
        val stdin = scaela.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val x1V1X2V2 = stdin.readLine.split(" ")

        val x1 = x1V1X2V2(0).trim.toInt

        val v1 = x1V1X2V2(1).trim.toInt

        val x2 = x1V1X2V2(2).trim.toInt

        val v2 = x1V1X2V2(3).trim.toInt

        val result = kangaroo(x1, v1, x2, v2)

        printWriter.println(result)

        printWriter.close()
    }
}
