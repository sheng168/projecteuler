/**
 *
 */
package euler.p000

import scala.io.Source



case class Node(val cost: Int, var sum: Int = 0, var parent: Node = null)