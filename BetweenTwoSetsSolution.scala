/** You will be given two arrays of integers. You will be asked to determine all integers
 *  that satisfy the following two conditions:
 *  1> The elements of the first array are all factors of the integer being considered
 *  2> The integer being considered is a factor of all elements of the second array
 *
 *  These numbers are referred to as being between the two arrays. You must determine how
 *  many such numbers exist.
 *
 *  Input Format
 *  The first line contains two space-separated integers describing the respective values of n, the
 *  number of elements in array a, and m, the number of elements in array b
 *  The second line contains n distinct space-separated integers describing a[0], a[1], ..., a[n-1]
 *  The third line contains  distinct space-separated integers describing a[0], a[1], ..., a[n-1]
 */
import java.io.PrintWriter
import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

object BetweenTwoSetsSolution {
    /** Get all common multiples for an array of Int values
     */
    def getMultiples(min: Int, max: Int, a: Array[Int]): Array[Int] = {
        val buf = ArrayBuffer[Int]()
        var m: Int = min
        while (m <= max) {
            breakable {
                for (x <- a) {
                    if ((m.toDouble / x.toDouble) % 1 != 0) {
                        break
                    }
                }
                buf += m
            }
            m += min
        }

        return buf.toArray
    }

    /** Get all divisors for a given Int
     */
    def getFactors(min: Int, n: Int): Array[Int] = {
        val factBuf = ArrayBuffer[Int]()
        val d = n.toDouble
        for (x <- min to n) {
            if ((d / x.toDouble) % 1 == 0) {
                factBuf += x
            }
        }
        return factBuf.toArray
    }

    /** Get common factors for an array if Int values
     */
    def getCommonFactors(min: Int, a: Array[Int]): Array[Int] = {
        val s: Array[Int] = a.sorted
        val factBuf = ArrayBuffer[Int]()

        // get common divisors of first number
        factBuf.appendAll(getFactors(min, s(0)))
        
        // remove divisors that are not common with subsequent numbers
        for (i <- 1 until s.length) {
            val factors = getFactors(min, s(i))
            for (f <- factBuf.toArray) {
                if (!factors.contains(f)) {
                    factBuf -= f
                }
            }
            
        }
        return factBuf.toArray
    }

    /** Complete the getTotalX function below.
     */
    def getTotalX(a: Array[Int], b: Array[Int]): Int = {
        val maxA = a.max
        val minB = b.min
        val mult: Array[Int] = getMultiples(maxA, minB, a)
        val fact: Array[Int] = getCommonFactors(maxA, b)

        // get common integers
        val common = for (m <- mult if fact.contains(m)) yield m
        return common.length
    }


    def main(args: Array[String]) {
        val scan = scala.io.StdIn

        val fw = new PrintWriter(sys.env("OUTPUT_PATH"))

        val nm = scan.readLine.split(" ")

        val n = nm(0).trim.toInt

        val m = nm(1).trim.toInt

        val a = scan.readLine.split(" ").map(_.trim.toInt)

        val b = scan.readLine.split(" ").map(_.trim.toInt)
        val total = getTotalX(a, b)

        fw.println(total)

        fw.close()
    }
}
