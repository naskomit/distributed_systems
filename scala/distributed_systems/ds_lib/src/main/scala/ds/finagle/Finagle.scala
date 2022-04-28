package ds.finagle

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http
import com.twitter.util.{Await, Future}

object Finagle extends com.twitter.app.App {

  val service = new Service[http.Request, http.Response] {
    override def apply(req: http.Request): Future[http.Response] = Future.value(
      http.Response(req.version, http.Status.Ok)
    )
  }

  val server = Http.serve(":8080", service)
  server

//  premain {Dtabs.init()}
  onExit(println("Shutting down"))

  def main(): Unit = {
    closeOnExit(server)
    Await.ready(server)
  }

  //  def run(): Unit = {
//    println("Finagle")
//  }
}
