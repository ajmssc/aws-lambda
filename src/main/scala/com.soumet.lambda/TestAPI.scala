package com.soumet.lambda


import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.soumet.gradle.lambda.annotations.LambdaAPIGatewayEndpoint
import com.soumet.gradle.lambda.annotations.HttpMethod

import scala.beans.BeanProperty

/**
 * Created by ajmssc on 12/11/15.
 * Description: 
 */
class Response (@BeanProperty var result : String) {
  def this() = this(result = "")

}
class Request (@BeanProperty var firstName: String, @BeanProperty var lastName: String, @BeanProperty var Authorization: String) {
  def this() = this(firstName = "", lastName = "", Authorization = "")
}

class TestAPI {
//  class TestAPI extends RequestHandler[Request, Response] {


  @LambdaAPIGatewayEndpoint(path="/test", method = HttpMethod.POST)
  def handlePost(input: Request, context: Context): Response = {
    val greetingString = String.format("Hello %s %s. %s, %s", input.firstName,
      input.lastName,
      context.getIdentity.getIdentityId,
      context.getInvokedFunctionArn);
    new Response(greetingString)
  }


  @LambdaAPIGatewayEndpoint(path="/test", method = HttpMethod.GET)
  def handleGet(context: Context): Response = {
    new Response("Sweeeet")
  }
}




