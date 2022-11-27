package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null){
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("您尚未登陆，不能访问主页");
            return;
        }
        String username = (String) session.getAttribute("username");

        resp.getWriter().write("欢迎来到主页！"+ username);
    }
}
