package logics.event

import logics.common.AbstractLogic
import daos.Events
import scala.concurrent.Future
import slick.driver.H2Driver.api._

object DeleteLogic extends AbstractLogic {
  def logic(id: Int): Future[Int] = {
    val action = Events.remove(id)
    db.run(action)
  }
}
