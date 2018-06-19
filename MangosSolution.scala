import scala.collection.mutable.ListBuffer

/** Solution for Mangos problem decriber in ./mangos.md
 *
 * Currently solves the problem naievly by calculating the comsumption of each combination
 * of friends that could be invited, and determining the size of the largest acceptable group.
 */
object MangosSolution {
    /** Given the list of friends you wish to invite, calculates how many mangoes they wil comsume
     *
     *  @param f friends that have been invited
     *  @param a appetite of all friends
     *  @param h hapiness factor of all friends
     */
    def getConsumption(f: List[Int], a: List[Int], h: List[Int]): Int = {
        // if no fiends are invited, you won't eat any mangoes
        if (f.length < 1) {
            return 0
        }

        // calculate the consumption for the friends you invited
        val p = f.length - 1
        var result = 0
        for(i <- f) {
            result += (a(i) + p*h(i))
        }
        return result
    }


    /** Finds the max number of invities that you can invite to your party
     *
     *  @param n total number of friends
     *  @param m total number of mangos 
     *  @param a appetite of all friends
     *  @param h hapiness factor of all friends
     */
    def getMaxInvitees(n: Int, m: Long, a: List[Int], h: List[Int]): Int = {
        // get all combinations of friends using a binary counter
        val superset = (0 until n).toList
        val totalSets = scala.math.pow(2, superset.length).toInt
        var max = 0
        
        for(i <- 1 until totalSets) {
            val subset = ListBuffer[Int]()
            for (p <- 0 until n) {
                val r = i >> p
                if ((1 & r) == 1) {
                    subset += superset(p)
                }
            }
            val c = getConsumption(subset.toList, a, h)
            val size = subset.length
            if (c <= m && size > max) {
                max = size
            }
        }

        return max
    }


    def runTest(expected: Int, n: Int, m: Long, a: List[Int], h: List[Int]) = {
        val t0 = System.nanoTime()
        val max = getMaxInvitees(n, m, a, h)
        val t1 = System.nanoTime()

        if (expected == max) {
            println(s"PASS :: max == $max ($expected enxpected) in ${t1 - t0}ns")
        } else {
            println(s"FAIL :: max == $max ($expected enxpected) in ${t1 - t0}ns")
        }
    }

    def main(args: Array[String]): Unit = {
        runTest(
            3,
            5, 200L,
            List(2, 5, 3, 2, 4),
            List(30, 40, 10, 20, 30))

        runTest(
            2,
            2, 100L,
            List(3, 4),
            List(1, 2))

        runTest(
            1,
            10, 100L,
            List(100, 1000, 10000, 100000, 1000000, 1000000, 100000, 1000000, 1000000, 100),
            List(100, 1000, 10000, 100000, 1000000, 1000000, 100000, 1000000, 1000000, 100))

        runTest(
            10,
            10, 100000000000000L,
            List(100, 1000, 10000, 100000, 1000000, 1000000, 100000, 1000000, 1000000, 100),
            List(100, 1000, 10000, 100000, 1000000, 1000000, 100000, 1000000, 1000000, 100))
    }
}
