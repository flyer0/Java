package admin;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
  private String getLoginForm() {
    return "<html>\n<head><title>Login Page</title></head>\n" + "<body bgcolor=\"white\">\n"
        + "<form method=\"post\">\n" + "<input type=\"text\" name=\"username\">\n"
        + "<input type=\"submit\" name=\"button\"" + "value=\"Login\"></form>\n" + "</body></html>";
  }
  private String getLogoutPage(String user) {
    return "<html>\n<head><title>Logout Page</title></head>\n" + "<body bgcolor=\"white\">\n"
        + "<h3>Hello " + user + "</h3>"
        + "<form method=\"post\">\n"
        + "<input type=\"submit\" name=\"button\"" + "value=\"Logout\"></form>\n" + "</body></html>";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    javax.servlet.http.HttpSession session = request.getSession();
    java.io.PrintWriter out = response.getWriter();
    if (session.isNew()) {
      session.setAttribute("user", new User());
      out.println(getLoginForm());
    } else { // this must be a logout
      response.sendRedirect(request.getContextPath() + "/login");
      session.invalidate();
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    javax.servlet.http.HttpSession session = request.getSession();
    java.io.PrintWriter out = response.getWriter();
    if (session.isNew()) {
      session.setAttribute("user", new User());
      out.println(getLoginForm());
    } else {
      User u = (User) session.getAttribute("user");
      if (request.getParameter("button").equals("Login")) {
        u.setName(request.getParameter("username"));
        out.println(getLogoutPage(u.getName()));
      } else { // this must be a logout
        out.println("<html><body>Good bye " + u.getName() +"</body></html>");
        session.invalidate();
      }
    }
  }
}
