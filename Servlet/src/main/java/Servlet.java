import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    Map<String, String> map;

    @Override
    public void init() throws ServletException {
        map = new HashMap<String, String>();
        map.put("Sergey", "qwerty");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pas = req.getParameter("pas");
        if (map.containsKey(name) && map.get(name).equals(pas)) {
            req.setAttribute("flag", true);
            req.setAttribute("message", "Hello " + name);
            getServletConfig().getServletContext().getRequestDispatcher("/views/hello.jsp").forward(req, resp);
        } else {
            req.setAttribute("flag", false);
            getServletConfig().getServletContext().getRequestDispatcher("/views/hello.jsp").forward(req, resp);
        }
    }

}