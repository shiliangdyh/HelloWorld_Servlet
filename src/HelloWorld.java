import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    private String msg = null;

    @Override
    public void init() throws ServletException {
        super.init();
        msg = "this is first servlet.";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter print = resp.getWriter();
        print.println("<h1>" + msg + "</h1>");
    }
}
