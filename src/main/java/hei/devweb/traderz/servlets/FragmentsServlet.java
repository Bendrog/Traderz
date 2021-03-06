package hei.devweb.traderz.servlets;

import hei.devweb.traderz.entities.User;
import hei.devweb.traderz.managers.UserManager;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FragmentsServlet extends PrivateServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userconnected = (String) req.getSession().getAttribute("user");
        WebContext context = new WebContext(req, resp, req.getServletContext());
        User user = UserManager.getInstance().CreateUserFromPseudo(userconnected);
        context.setVariable("useronline", user );

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("fragments", context, resp.getWriter());
    }
}
