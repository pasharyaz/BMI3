package app.servlets;

import app.entities.BmiData;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

        List<Double> bmiList = model.listBmi();
        List<String> bmiListResult = model.listResult();

        req.setAttribute("lastBMI", bmiData);
        req.setAttribute("bmi", bmiList);
        req.setAttribute("bmiResult", bmiListResult);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/BMI.jsp");
        requestDispatcher.forward(req, resp);
    }
}
