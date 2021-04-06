package Calc

import org.scalatest.funsuite.AnyFunSuite

class SquareCalculatorTest extends AnyFunSuite {

  test("testSquare") {
    val sc = new SquareCalculator()
    assert(sc.square(2) === 4)
  }

}
