package entities

import slick.model.Table
import slick.driver.MySQLDriver.api._
import slick.lifted.{ProvenShape, ForeignKeyQuery}

/**
  * Created by kkk on 16/1/10.
  */
class User(tag: Tag) extends Table[(Int, String, String, String, String, String)](tag, "SUPPLIERS") {
  def id = column[Int]("SUP_ID", O.PrimaryKey) // This is the primary key column
  def name = column[String]("SUP_NAME")
  def street = column[String]("STREET")
  def city = column[String]("CITY")
  def state = column[String]("STATE")
  def zip = column[String]("ZIP")
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (id, name, street, city, state, zip)
}
val users = TableQuery[User]
