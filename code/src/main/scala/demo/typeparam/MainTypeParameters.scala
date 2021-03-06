package demo.typeparam

import demo.typeparam.model._
import demo.typeparam.model.Order

object MainTypeParameters {

  def app() = {
    println("--------------------------------------------------------")
    println("Type Parameters")
    println("")

    BackendParam.configure(Order.behavior)

    val orderRef = BackendParam.aggregateRef[Order, OrderCommand, OrderEvent]

    orderRef ! CreateOrder(1, "abc")
    orderRef ! AddItem(Item("001-FG", "product 1", 10))
    orderRef ! AddItem(Item("002-HI", "product 2", 100))
    orderRef ! AddItem(Item("003-LM", "product 3", 1000))
    orderRef ! RemoveItem("003-LM")

    orderRef.getEvents.foreach { evt =>
      println(s"Event: $evt")
    }

    println(orderRef.state())
    println("--------------------------------------------------------")
    println()
    println()

  }
}
