package logics.event

import logics.common.AbstractLogic
import daos.Events
import models.Tables.EventRow
import forms.sample.EventUpdateData
import scala.concurrent.Future
import slick.driver.H2Driver.api._

object UpdateLogic extends AbstractLogic {
  def logic(data: EventUpdateData): Future[Int] = {
    val eventRow = EventRow(data.id ,data.eventId ,data.eventNm ,data.eventDate ,data.homepage ,data.place ,data.capacity ,data.eventType ,data.content ,data.publicStatus)
    val action = Events.update(eventRow)
    db.run(action)
  }
}
