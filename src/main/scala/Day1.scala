import java.io.File
import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.Try

object Day1:

  def part1(): Int =
    val source = Source.fromResource("day-1-part-1.txt")
    var maxSum: Int = 0
    source.getLines().foldLeft(0) { (acc: Int, str: String) =>
      if (str.isBlank) {
        maxSum = math.max(maxSum, acc)
        0
      } else {
        acc + str.toInt
      }
    }
    source.close()
    maxSum

  def part2(): Int =
    val source = Source.fromResource("day-2-part-2.txt")
    val sums = ListBuffer.empty[Int]
    source.getLines().foreach { (str: String) =>
      if (str.isBlank) {
        sums.append(0)
      } else {
        if (sums.isEmpty) {
          sums.append(0)
        }
        sums.update(sums.length - 1, sums.last + str.toInt)
      }
    }
    source.close()
    val sorted = sums.sorted(Ordering[Int].reverse)
    sorted.head + sorted(1) + sorted(2)



