package logics.event

import logics.common.AbstractLogic
import daos.Events
import models.Tables.EventRow
import forms.sample.EventSearchData
import scala.concurrent.Future
import slick.driver.H2Driver.api._

object SearchLogic extends AbstractLogic {

  def logic(data: EventSearchData): Future[Seq[EventRow]] = {
    val action = Events.filter(data)
    db.run(action)
  }
}
