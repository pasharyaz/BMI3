package app.servlets;

import app.entities.BmiData;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubmitServlet extends HttpServlet {
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");
        BmiData bmiData = new BmiData(height, weight);
        Model model = Model.getInstance();
        model.add(bmiData);


        req.setAttribute("model", model.arrayBMI());
        req.setAttribute("lastBMI", bmiData);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/BMI.jsp");
        requestDispatcher.forward(req, resp);
    }
}
