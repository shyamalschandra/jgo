package jgo.compiler
package interm

import codeseq._
import instr._
import symbol._
import types._

/**
 * The intermediate representation of a certain func.
 */
sealed abstract class FuncInterm extends Typed {
  val target: Func
  val params:  List[LocalVar]
  val results: List[LocalVar]
  val code: Code
  
  lazy val typeOf: FuncType = target.typeOf
  lazy val resultCount: Int = results.length
  def isVariadic: Boolean = typeOf.isVariadic
}

/**
 * The intermediate representation of a certain (top-level) function.
 */
case class FunctionInterm(
    target: Function,
    params:  List[LocalVar],
    results: List[LocalVar],
    code: Code)
extends FuncInterm

/**
 * The intermediate representation of a certain method.
 */
case class MethodInterm(
    target: Method,
    receiver: LocalVar,
    params:  List[LocalVar],
    results: List[LocalVar],
    code: Code)
extends FuncInterm
