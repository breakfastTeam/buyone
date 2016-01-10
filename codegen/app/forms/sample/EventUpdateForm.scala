package forms.sample

import play.api.data._
import play.api.data.Forms._
import models.Tables.EventRow
import java.sql.Date

case class EventUpdateData(
  id: Int,
  eventId: String,
  eventNm: String,
  eventDate: Option[Date],
  homepage: Option[String],
  place: Option[String],
  capacity: Option[String],
  eventType: Option[String],
  content: Option[String],
  publicStatus: Option[String])

trait EventUpdateForm {
  val eventUpdateForm = Form(
    mapping(
      "id" -> number(min = 0, max = 100),
      "eventId" -> nonEmptyText(maxLength = 100),
      "eventNm" -> nonEmptyText(maxLength = 100),
      "eventDate" -> optional(sqlDate),
      "homepage" -> optional(text(maxLength = 100)),
      "place" -> optional(text(maxLength = 100)),
      "capacity" -> optional(text(maxLength = 100)),
      "eventType" -> optional(text(maxLength = 100)),
      "content" -> optional(text(maxLength = 100)),
      "publicStatus" -> optional(text(maxLength = 100))
      )(EventUpdateData.apply)(EventUpdateData.unapply))
}