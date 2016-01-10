package controllers.sample.eventcreate

import play.api.i18n.Messages.Implicits._
import play.api.mvc._
import play.api.Play.current
import logics.event.IndexLogic
import forms.sample.EventCreateForm
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import controllers.common.AbstractController

trait Index extends AbstractController with EventCreateForm {

  def index = Action.async { implicit request =>
    IndexLogic.logic
    Future {
      Ok(views.html.sample.eventCreate(eventCreateForm))
    }
  }
}