package daos

import models.Tables._
import daos.common.AbstractDao
import slick.driver.H2Driver.api._

abstract class AbstractEvents extends AbstractDao {
  /** insert */
  def insert(e: EventRow) = DBIO.seq(Event += e)

  /** update */
  def update(e: EventRow) =
    Event.filter(t => t.id === e.id).update(e)

  /** delete */
  def remove(id: Int) =
    Event.filter(t => t.id === id).delete

  /** find by id */
  def filterById(id: Int): DBIO[Option[EventRow]] =
    Event.filter(t => t.id === id).result.headOption

  /** find all data */
  def all: DBIO[Seq[EventRow]] =
    Event.sortBy(f => (f.id)).result

  /** filter everything */
  def filter(condition: Any): DBIO[Seq[EventRow]] =
    filter(condition, Event).result

  /** data length */
  def length(condition: Any): DBIO[Int] =
    filter(condition, Event).length.result

}
