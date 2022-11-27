package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //正常是和数据库中的数据验证，现在是写死用户名和密码
        if ("zhangsan".equals(username) && "123".equals(password)) {
            //登陆成功
            HttpSession session = req.getSession(true);
            session.setAttribute("username","zhangsan");
            resp.sendRedirect("index");
        }else{
            //登陆失败

            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("登陆失败，用户名或密码错误!");
        }


    }
}
