import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.TemplateHandler;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;

public class TemplateHandlerWindowsPathSample {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    Router router = Router.router(vertx);

    ThymeleafTemplateEngine engine = ThymeleafTemplateEngine.create(vertx);
    TemplateHandler handler = TemplateHandler.create(engine, "templates", "text/html");

    router.getWithRegex(".+\\.html").handler(handler);

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8080, "127.0.0.1")
      .onSuccess(server -> System.out.println("Listening on http://127.0.0.1:8080"));
  }
}
