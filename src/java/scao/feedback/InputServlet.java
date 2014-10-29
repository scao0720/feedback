package scao.feedback;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InputServlet", urlPatterns = {"/feedback/", "/feedback/new"})
public class InputServlet extends HttpServlet {

    @EJB
    private InputFacade inputFacade;
    @EJB
    private FeedbackTypeFacade typeFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        String view = path;

        // if report page is requested
        if (path.equals("/feedback/")) {
            // store inputs list in servlet context
            getServletContext().setAttribute("inputs", inputFacade.findAll());
            view = "/report";

        } else if (path.equals("/feedback/new")) {
            // store feedback types list in servlet context
            getServletContext().setAttribute("types", typeFacade.findAll());
            System.out.println("loaded types:" + typeFacade.findAll().size());
            view = "/new";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + view + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        // if create action is requested
        if (path.equals("/feedback/")) {
            FeedbackType type = typeFacade.find(Integer.parseInt(request.getParameter("type")));
            Input feedback = new Input(null, request.getParameter("name"), request.getParameter("email"));
            feedback.setComment(request.getParameter("comment"));
            feedback.setScale(Integer.parseInt(request.getParameter("scale")));
            feedback.setOther(request.getParameter("other"));
            feedback.setCreated(new Date());
            feedback.setTypeId(type);
            inputFacade.create(feedback);
            response.sendRedirect(request.getContextPath() + "/thanks.jsp");
        }
    }
}
