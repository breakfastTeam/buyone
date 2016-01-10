package controllers.sample.eventupdate

import play.api.i18n.Messages.Implicits._
import play.api.mvc._
import play.api.Play.current
import logics.event.UpdateLogic
import forms.sample.EventUpdateForm
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait Update extends Controller with EventUpdateForm {

  def update(id: Int) = Action.async { implicit request =>
    eventUpdateForm.bindFromRequest.fold(
      hasErrors = { form =>
        Future {
          BadRequest(views.html.sample.eventUpdate(form, id))
        }
      },
      success = { form =>
        UpdateLogic.logic(form).map {
          case count: Int if (count > 0) =>
            Redirect(controllers.sample.routes.EventUpdate.index(id))
              .flashing("success" -> "Update was successful.")
          case _ =>
            Redirect(controllers.sample.routes.EventUpdate.index(id))
              .flashing("error" -> "Update was not successful.")
        }
      })
  }
}
