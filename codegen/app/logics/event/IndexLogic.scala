package logics.event

import logics.common.AbstractLogic
import daos.Events
import models.Tables.EventRow
import scala.concurrent.Future
import slick.driver.H2Driver.api._

object IndexLogic extends AbstractLogic {

  def logic = {
    None
  }

  def logic(id: Int): Future[Option[EventRow]] = {
    val action = Events.filterById(id)
    db.run(action)
  }
}
