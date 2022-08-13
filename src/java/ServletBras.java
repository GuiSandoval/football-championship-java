
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ServletBras"})
public class ServletBras extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametrof = request.getParameter("parametroFla");
        String parametroc = request.getParameter("parametroCor");

        parametrof += " agora com valor alterado";
        parametroc += " agora com valor alterado";

        request.setAttribute("parametroFlaJsp", parametrof);
        request.setAttribute("parametroCorJsp", parametroc);

        request.getRequestDispatcher("Tabela.jsp").forward(request, response);
    }
}

