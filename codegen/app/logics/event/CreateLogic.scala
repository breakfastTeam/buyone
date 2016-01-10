package logics.event

import logics.common.AbstractLogic
import daos.Events
import models.Tables.EventRow
import forms.sample.EventCreateData
import scala.concurrent.Future
import slick.driver.H2Driver.api._

object CreateLogic extends AbstractLogic {

  def logic(data: EventCreateData): Future[Unit] = {
    val eventRow = EventRow(0, data.eventId, data.eventNm, data.eventDate, data.homepage, data.place, data.capacity, data.eventType, data.content, data.publicStatus)
    val action = Events.insert(eventRow)
    db.run(action)
  }
}
