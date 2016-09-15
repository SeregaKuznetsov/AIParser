package ru.itis2016;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet({"/Calculator"})
public class ServletCalculator extends TestEncodinServlet {

    private String buttoms  = "<form action=\"Calculator\" method=\"post\">" +
            "<input type=\"text\" name=\"digit\" >" +
            "<input type=\"submit\" name=\"mathAction\" value =\"addition\" >" +
            "<input type=\"submit\" name=\"mathAction\" value =\"subtraction\" >" +
            "<input type=\"submit\" name=\"mathAction\" value =\"multiplication\" >" +
            "<input type=\"submit\" name=\"mathAction\" value =\"division\" >" +
            "<input type=\"submit\" name=\"mathAction\" value =\"equally\" >" +
            "</input>" +
            "</input>" +
            "</input>" +
            "</input>" +
            "</input>" +
            "</input>" +
            "</form>";

    static Logger log = Logger.getLogger(ru.itis2016.ServletCalculator.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        resp.setContentType("text/html;charset=UTF-8");
        String text = req.getParameter("digit");
        String mathAction = req.getParameter("mathAction");
        System.out.println("GET txt - " + text);
        System.out.println("GET Math - " + mathAction);
        HttpSession session = req.getSession();
        session.setAttribute("historyOfNumber", null);
        session.setAttribute("historyOfMathAction", null);
        String historyOfNumber = (String) session.getAttribute("historyOfNumber");
        String histOfMathAction = (String) session.getAttribute("historyOfMathAction");
        resp.getWriter().write("Первое значение равно " + text + "<BR>" +
                buttoms +
                "<br>Прошлое введеное значение как оно сохранено в сессии " + historyOfNumber +
                "<br>Прошлая математическая операция как она сохранена в сессии " + histOfMathAction );
        session.setAttribute("historyOfNumber", text);
        session.setAttribute("histOfMathAction", mathAction);
        log.info("Text that was added to session: " + text);
        log.info("mathAction that was added to session: " + mathAction);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("ISO-8859-1");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        String text = req.getParameter("digit");
        String mathAction = req.getParameter("mathAction");
        System.out.println("POST text- " + text);
        System.out.println("POST mathACt- " + mathAction);
        if ((session.getAttribute("historyOfNumber") == null) || (session.getAttribute("histOfMathAction") == null)) {
            session.setAttribute("historyOfNumber", text);
            session.setAttribute("histOfMathAction", mathAction);
            System.out.println("Кто то ноль и я установил число " + session.getAttribute("historyOfNumber"));
            System.out.println("Кто то ноль и я установил операцию " + session.getAttribute("histOfMathAction"));
            resp.getWriter().write("Введено было значение " + session.getAttribute("historyOfNumber") + "<BR>" +
                    buttoms +
                    "<br>Равно " +
                    "<br>Прошлое введеное значение как оно сохранено в сессии " + session.getAttribute("historyOfNumber") +
                    "<br>Прошлая математическая операция как она сохранена в сесссии " + session.getAttribute("histOfMathAction"));
        } else {
            if (!mathAction.equals("equally")) {
                if (text.equals("0")) {
                    resp.getWriter().write("Введено было значение " + text + "<BR>" +
                            buttoms +
                            "<br>Дружище, ты делишь на ноль, не надо так" +
                            "<br>Прошлое введеное значение как оно сохранено в сессии " + session.getAttribute("historyOfNumber") +
                            "<br>Прошлая математическая операция как она сохранена в сесссии " + session.getAttribute("histOfMathAction"));
                } else {
                    double sum = getResult(parse((String) session.getAttribute("historyOfNumber")), parse(text), mathAction);
                    resp.getWriter().write("Введено было значение " + text + "<BR>" +
                            buttoms +
                            "<br>Равно " +
                            "<br>Сумма ранее введенных значений как они сохранены в сессии " + sum +
                            "<br>Прошлая математическая операция как она сохранена в сесссии " + mathAction);
                    session.setAttribute("historyOfNumber", Double.toString(sum));
                    session.setAttribute("histOfMathAction", mathAction);
                }
            }
        }
        if (mathAction.equals("equally")) {
            if (text.equals("0")) {
                resp.getWriter().write("Введено было значение " + text + "<BR>" +
                        buttoms +
                        "<br>Дружище, ты делишь на ноль, не надо так" +
                        "<br>Прошлое введеное значение как оно сохранено в сессии " + session.getAttribute("historyOfNumber") +
                        "<br>Прошлая математическая операция как она сохранена в сесссии " + session.getAttribute("histOfMathAction"));
            } else
                resp.getWriter().write("Введено было значение " + text + "<BR>" +
                        buttoms +
                        "<br>Равно " + getResult(parse((String)session.getAttribute("historyOfNumber")), parse(text), (String)session.getAttribute("histOfMathAction")) +
                        "<br>Прошлое введеное значение как оно сохранено в сессии " + session.getAttribute("historyOfNumber") +
                        "<br>Прошлая математическая операция как она сохранена в сесссии " + session.getAttribute("histOfMathAction"));

            session.setAttribute("historyOfNumber", null);
            session.setAttribute("historyOfMathAction", null);
        }
    }



    private double getResult(double operand1, double operand2, String operation) {
        double result = 0;
        if (operation.equals("addition")) {
            return operand1 + operand2;
        }
        if (operation.equals("subtraction")) {
            return operand1 - operand2;
        }
        if (operation.equals("multiplication")) {
            return operand1 * operand2;
        }
        if (operation.equals("division")) {
            return operand1 / operand2;
        }
        return result;
    }

    private double parse(String num) {
        return Double.parseDouble(num);
    }
}
