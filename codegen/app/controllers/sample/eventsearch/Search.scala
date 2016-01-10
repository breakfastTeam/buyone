package controllers.sample.eventsearch

import play.api.i18n.Messages.Implicits._
import play.api.mvc._
import play.api.Play.current
import models.Tables._
import logics.event.SearchLogic
import forms.sample.EventSearchForm
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait Search extends Controller with EventSearchForm {

  def search = Action.async { implicit request =>
    eventSearchForm.bindFromRequest.fold(
      hasErrors = { form =>
        Future {
          BadRequest(views.html.sample.eventSearch(form, List.empty[EventRow]))
        }
      },
      success = { form =>
        SearchLogic.logic(form).map {
          case events if (events.length > 0) =>
            Ok(views.html.sample.eventSearch(eventSearchForm.bindFromRequest, events))
          case _ =>
            BadRequest(views.html.sample.eventSearch(
              eventSearchForm.withGlobalError("No data found.").bindFromRequest, Seq.empty[EventRow]))
        }
      })
  }
}
