import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servlet extends HttpServlet {
    FileFinder fileFinder;
    ArrayList<String> list;

    @Override
    public void init() throws ServletException {
        fileFinder = new FileFinder();
        list = new ArrayList<String>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dir = req.getParameter("directory");
        String mask = req.getParameter("mask");
        req.setAttribute("list" , fileFinder.findFile(dir, mask, list));
        getServletConfig().getServletContext().getRequestDispatcher("views/hello.jsp").forward(req,resp);

    }
}
