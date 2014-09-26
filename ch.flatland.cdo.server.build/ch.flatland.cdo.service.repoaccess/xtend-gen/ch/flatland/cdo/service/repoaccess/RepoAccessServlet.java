package ch.flatland.cdo.service.repoaccess;

import ch.flatland.cdo.util.Json;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
public class RepoAccessServlet extends HttpServlet {
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    String _jsonContentTypeUTF8 = Json.jsonContentTypeUTF8();
    resp.setContentType(_jsonContentTypeUTF8);
    PrintWriter _writer = resp.getWriter();
    _writer.append("Hallo Repo Access");
  }
}
