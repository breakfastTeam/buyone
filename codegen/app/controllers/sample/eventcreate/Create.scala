package controllers.sample.eventcreate

import play.api.i18n.Messages.Implicits._
import play.api.mvc._
import play.api.Play.current
import logics.event.CreateLogic
import forms.sample.EventCreateForm
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait Create extends Controller with EventCreateForm {

  def create = Action.async { implicit request =>
    eventCreateForm.bindFromRequest.fold(
      hasErrors = { form =>
        Future {
          BadRequest(views.html.sample.eventCreate(form))
        }
      },
      success = { form =>
        CreateLogic.logic(form)
        Future {
          Redirect(controllers.sample.routes.EventCreate.index)
            .flashing("success" -> "Registration was successful.")
        }
      })
  }
}
