package app.servlets;

import app.entities.BmiData;
import app.model.BmiList;
import com.google.inject.Injector;

import javax.inject.Singleton;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class SubmitServlet extends HttpServlet {
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/BMI.jsp");
        requestDispatcher.forward(req, resp);
    }*/
    private static Injector INJECTOR = new MyGuiceListener().getInjector();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");

       /* Model model = Model.getInstance();
        model.add(bmiData);

        req.setAttribute("model", model.arrayBMI());*/


        BmiData bmiData = INJECTOR.getInstance(BmiData.class);
        BmiList bmiList = INJECTOR.getInstance(BmiList.class);

        bmiData.setHeight(height);
        bmiData.setWeight(weight);
        bmiData.setBmi();
        bmiData.setBmiResult();

        req.setAttribute("lastBMI", bmiData);


        bmiList.add(bmiData);
        req.setAttribute("BmiList", bmiList.BmiArray());


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/BMI.jsp");
        requestDispatcher.forward(req, resp);
    }
}
