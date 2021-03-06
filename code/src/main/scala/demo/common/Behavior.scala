package demo.common

import demo.{ ClassTagExtractor, CommandHandler, EventHandler }

import scala.reflect.ClassTag

trait Behavior[A, C, E] {

  def onCommand(cmd: C): List[E]

  def onCommand(agg: A, cmd: C): List[E]

  def onEvent(evt: E): A

  def onEvent(agg: A, evt: E): A
}
