package edu.neu.coe.csye7200

import scala.util.{Success, Try}

/**
  * Created by scalaprof on 10/7/16.
  */
trait Parseable[T] {
  def parse(s: String): Try[T]
}

object Parseable {

  trait ParseableInt extends Parseable[Int] {
    def parse(s: String): Try[Int] = Try(s.toInt)
  }

  implicit object ParseableInt extends ParseableInt

}

object TestParseable {
  // desugar it as:
  // def parse[T](s: String)(implicit ev: Parseable[T]): Try[T] = ev.parse(s)
  def parse[T: Parseable](s: String): Try[T] = implicitly[Parseable[T]].parse(s)
}
