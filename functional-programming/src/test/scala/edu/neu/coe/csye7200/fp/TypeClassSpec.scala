package edu.neu.coe.csye7200.fp

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.language.postfixOps
import scala.util.Success

class TypeClassSpec extends AnyFlatSpec with Matchers {

  import edu.neu.coe.csye7200.TestParseable._

  behavior of "TypeClass"

  it should "parse String 123 to Int 123" in {
    parse("123") shouldBe Success(123)
  }


}
