package hei.devweb.traderz.servlets;

import hei.devweb.traderz.dao.impl.TransactionDaoImpl;
import hei.devweb.traderz.dao.impl.UserDaoImpl;
import hei.devweb.traderz.entities.Cotation;
import hei.devweb.traderz.entities.User;
import hei.devweb.traderz.managers.CotationManager;
import hei.devweb.traderz.managers.UserManager;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Prive/vendreCotation")
public class VendreCotationServlet extends PrivateServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String companyId = req.getParameter("id");
        Cotation cotation = CotationManager.getInstance().CreateCotationFromId(Integer.parseInt(companyId));
        context.setVariable("cotation", cotation);
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("vente", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.###"); // Utilisé pour donner un double avec seulement 2 chiffres
        String volume = req.getParameter("nbAction");
        Double volumeAction = Double.parseDouble(volume);
        String userconnected = (String) req.getSession().getAttribute("user");
        String companyId = req.getParameter("id");
        Cotation cotation = CotationManager.getInstance().CreateCotationFromId(Integer.parseInt(companyId));
        User user = UserManager.getInstance().CreateUserFromPseudo(userconnected);
        TransactionDaoImpl transactionDao = new TransactionDaoImpl();

        String valeurTransacString = df.format((cotation.getPrix()).doubleValue()*volumeAction); // passe en Double et permet de retourner le prix avec 2 chiffres après la virgule
        String valeurTransacStringValide = valeurTransacString.replaceAll(",","."); // change la virgule en point
        Double valeurportef = new UserDaoImpl().CreateValeur(userconnected);
        Double liquidite = new UserDaoImpl().CreateLiquidite(userconnected);
        Double valeurTransac = Double.parseDouble(valeurTransacStringValide);

        String errorMessage = null;
        try{
            if (volumeAction>0){
                transactionDao.VendreTransac(user, cotation, volumeAction);
                new UserDaoImpl().Debiter(liquidite, valeurportef, valeurTransac, userconnected);
                resp.sendRedirect("/Prive/cotations");
            }
        }catch (Exception e ) {
            errorMessage = e.getMessage();
        }
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("cotation", cotation);

        context.setVariable("errorMessage", errorMessage);
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("vente", context, resp.getWriter());
    }
}
