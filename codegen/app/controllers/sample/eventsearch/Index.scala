package controllers.sample.eventsearch

import play.api.i18n.Messages.Implicits._
import play.api.mvc._
import play.api.Play.current
import logics.event.IndexLogic
import forms.sample.EventSearchForm
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import controllers.common.AbstractController

trait Index extends AbstractController with EventSearchForm {

  def index = Action.async { implicit request =>
    IndexLogic.logic
    Future {
      Ok(views.html.sample.eventSearch(eventSearchForm, null))
    }
  }
}