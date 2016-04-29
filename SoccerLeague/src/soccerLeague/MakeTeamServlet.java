package soccerLeague;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeTeamServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        resp.getWriter().println("Hello, unknown user");

	}

}
