package forms.sample

import play.api.data._
import play.api.data.Forms._
import models.Tables.EventRow
import java.sql.Date
import scala.annotation.meta.field
import utils.annotations.searchcondition.{ Eq => ==, Ne => !=, Lt => <, Le => <=, Gt => >, Ge => >=, Contains => contains, StartWith => startwith, EndWith => endwith, In => in }

case class EventSearchData(
  @(== @field) eventId: Option[String],
  @(== @field) eventNm: Option[String],
  @(== @field) eventDate: Option[Date],
  @(== @field) homepage: Option[String],
  @(== @field) place: Option[String],
  @(== @field) capacity: Option[String],
  @(== @field) eventType: Option[String],
  @(== @field) content: Option[String],
  @(== @field) publicStatus: Option[String])

trait EventSearchForm {
  val eventSearchForm = Form(
    mapping(
      "eventId" -> optional(text(maxLength = 100)),
      "eventNm" -> optional(text(maxLength = 100)),
      "eventDate" -> optional(sqlDate),
      "homepage" -> optional(text(maxLength = 100)),
      "place" -> optional(text(maxLength = 100)),
      "capacity" -> optional(text(maxLength = 100)),
      "eventType" -> optional(text(maxLength = 100)),
      "content" -> optional(text(maxLength = 100)),
      "publicStatus" -> optional(text(maxLength = 100))
      )(EventSearchData.apply)(EventSearchData.unapply))
}