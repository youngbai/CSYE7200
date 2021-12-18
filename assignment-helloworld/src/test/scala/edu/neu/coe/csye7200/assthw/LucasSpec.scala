package edu.neu.coe.csye7200.assthw

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LucasSpec extends AnyFlatSpec with Matchers {

  // Solution1:
  // val lucasSeq: LazyList[BigInt] = BigInt(2) #:: BigInt(1) #:: lucasSeq.zip(lucasSeq.tail).map(n => n._1 + n._2)

  // Solution2:
  val lucasSeq: LazyList[BigInt] = BigInt(2) #:: lucasSeq.scanLeft(BigInt(1))(_ + _)

  def lucas(n: Int): BigInt = lucasSeq(n)

  behavior of "Lucas"

  it should "yield correct results for small n" in {
    lucas(0) shouldBe 2L
    lucas(1) shouldBe 1L
    lucas(2) shouldBe 3L
    lucas(3) shouldBe 4L
    lucas(4) shouldBe 7L
  }

}

