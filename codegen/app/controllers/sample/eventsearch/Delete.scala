package controllers.sample.eventsearch

import play.api.mvc._
import logics.event.DeleteLogic
import scala.concurrent.ExecutionContext.Implicits.global

trait Delete extends Controller {

  def delete(id: Int) = Action.async { implicit request =>
    DeleteLogic.logic(id).map {
      case count if (count > 0) =>
        Redirect(controllers.sample.routes.EventSearch.index)
          .flashing("success" -> "Delete was successful.")
      case _ =>
        Redirect(controllers.sample.routes.EventSearch.index)
          .flashing("error" -> "Delete was not successful.")
    }
  }
}
