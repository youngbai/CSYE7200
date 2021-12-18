package edu.neu.coe.csye7200.assthw

object Pell {

  /* non tail-recursive */
  //  def apply(n: Int): Long = n match {
  //    case 0 => 0L
  //    case 1 => 1L
  //    case x => 2 * apply(x - 1) + apply(x - 2)
  //  }

  /* tail-recursive */
  //val xs: LazyList[Long] = 0L #:: 1L #:: xs.zip(xs.tail).map(n => n._1 + 2 * n._2)

  /* tail-recursive2 */
  val xs: LazyList[Long] = 0L #:: xs.scanLeft(1L)(2 * _ + _)

  def apply(n: Int): Long = xs(n)

}
