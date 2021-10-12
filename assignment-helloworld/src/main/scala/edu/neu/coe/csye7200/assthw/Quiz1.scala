package edu.neu.coe.csye7200.assthw

import scala.annotation.tailrec

object Quiz1 extends App {

  /**
   * This is my solution
   *
   * What I learned:
   * - priceMap.get("A") will return Some(1.0) not 1.0
   *   we should `priceMap.get("A")`.get to get the real value
   *   or in a simple way `priceMap("A")` directly get the real value
   */
  def priceCheck_Solution1(products: Array[String], productPrices: Array[Float], productSold: Array[String], soldPrice: Array[Float]): Int = {
    case class Product(product: String, price: Float)

    val priceMap = (products zip productPrices).toMap

    val prodList = (for ((prod, price) <- productSold zip soldPrice) yield Product(prod, price)).toList

    @tailrec
    def inner(r: Int, _prodList: List[Product]): Int = {
      _prodList match {
        case Nil => r
        // solution 1
        // case h :: t if priceMap.get(h.product).get == h.price => inner(r, t)
        // case _ :: t => inner(r + 1, t)

        // solution 2
        // case h :: t => if (priceMap.get(h.product).get == h.price) inner(r, t) else inner(r + 1, t)

        // solution 3
        case h :: t => h match {
          case Product(product, price) => if (priceMap(product) == price) inner(r, t) else inner(r + 1, t)
        }
      }
    }

    inner(0, prodList)
  }


  /**
   * prof's solution
   */
  def priceCheck_Solution2(products: Array[String], productPrices: Array[Float], productSold: Array[String], soldPrice: Array[Float]): Int = {
    case class Product(product: String, price: Float) {
      def correct(p: Float): Boolean = price == p
    }

    val ps = for (p <- products zip productPrices) yield Product(p._1, p._2)
    val ss = for (p <- productSold zip soldPrice) yield Product(p._1, p._2)
    val sales = for (s <- ss; p <- ps.find(_.product == s.product).toSeq; if p.correct(s.price)) yield p
    ss.length - sales.length
  }

}
