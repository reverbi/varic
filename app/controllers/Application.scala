package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index: Action[AnyContent] = Action {
    Ok(views.html.index())
  }

}
