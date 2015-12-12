package com.soumet.lambda


import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}

import scala.beans.BeanProperty

/**
 * Created by ajmssc on 12/11/15.
 * Description: 
 */
class Response (@BeanProperty var result : String) {
  def this() = this(result = "")

}
class Request (@BeanProperty var firstName: String, @BeanProperty var lastName: String) {
  def this() = this(firstName = "", lastName = "")
}

class TestAPI {
//  class TestAPI extends RequestHandler[Request, Response] {


  def handlePost(input: Request, context: Context): Response = {
    val greetingString = String.format("Hello %s %s. %s, %s", input.firstName,
      input.lastName,
      context.getIdentity.getIdentityId,
      context.getInvokedFunctionArn);
    new Response(greetingString)
  }
}




