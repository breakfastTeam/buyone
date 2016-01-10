package controllers.sample.eventupdate

import play.api.i18n.Messages.Implicits._
import play.api.mvc._
import play.api.Play.current
import logics.event.IndexLogic
import forms.sample.{ EventUpdateForm, EventUpdateData }
import scala.concurrent.ExecutionContext.Implicits.global
import controllers.common.AbstractController

trait Index extends AbstractController with EventUpdateForm {

  def index(id: Int) = Action.async { implicit request =>
    IndexLogic.logic(id).map {
      case Some(event) =>
        val eventForm = EventUpdateData(event.id, event.eventId, event.eventNm, event.eventDate, event.homepage, event.place, event.capacity, event.eventType, event.content, event.publicStatus)
        Ok(views.html.sample.eventUpdate(eventUpdateForm.fill(eventForm), id))
      case _ =>
        BadRequest(views.html.sample.eventUpdate(
          eventUpdateForm.withGlobalError("No data found.").bindFromRequest, id))
    }
  }
}