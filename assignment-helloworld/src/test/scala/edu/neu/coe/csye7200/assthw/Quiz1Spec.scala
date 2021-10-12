package edu.neu.coe.csye7200.assthw

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Quiz1Spec extends AnyFlatSpec with Matchers{

  val products = Array("A", "B", "C")
  val productPrices = Array(1.0f, 2.0f, 3.0f)
  val productSold = Array("A", "B", "A", "C")
  val soldPrice = Array(1.1f, 2.0f, 1.0f, 3.1f) // 2

  behavior of "solution1: my solution"
  it should "get the correct answer" in {
    Quiz1.priceCheck_Solution1(products, productPrices, productSold, soldPrice) shouldBe 2
  }

  behavior of "solution2: prof solution"
  it should "get the correct answer" in {
    Quiz1.priceCheck_Solution2(products, productPrices, productSold, soldPrice) shouldBe 2
  }

}
