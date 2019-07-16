package app.servlets;

import app.entities.BmiData;
import app.model.BmiList;
import com.google.inject.Inject;
import com.google.inject.Provider;

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
         BmiData bmiDataProvider;
        BmiList bmiList = INJECTOR.getInstance(BmiList.class);
        bmiDataProvider = bmiList.getLastBmi();
        req.setAttribute("lastBMI", bmiDataProvider);
        req.setAttribute("BmiList", bmiList.getBmiList());


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/BMI.jsp");
        requestDispatcher.forward(req, resp);
    }*/

    private Provider<BmiData> bmiDataProvider;
    private BmiList bmiList;


    //  private static Injector INJECTOR = new MyGuiceListener().getInjector();

    @Inject
    public SubmitServlet(Provider<BmiData> bmiDataProvider, BmiList bmiList) {
        super();
        this.bmiDataProvider = bmiDataProvider;
        this.bmiList = bmiList;
    }


    @Override
    protected synchronized void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");

       /* Model model = Model.getInstance();
        model.add(bmiDataProvider);

        req.setAttribute("model", model.arrayBMI());*/


       /* BmiData bmiDataProvider = INJECTOR.getInstance(BmiData.class);
        BmiList bmiList = INJECTOR.getInstance(BmiList.class);*/
        BmiData bmiData = bmiDataProvider.get();

        bmiData.setHeight(height);
        bmiData.setWeight(weight);
        bmiData.setBmi();
        bmiData.setBmiResult();

        req.setAttribute("lastBMI", bmiData);


        bmiList.add(bmiData);
        req.setAttribute("BmiList", bmiList.getBmiList());


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/BMI.jsp");
        requestDispatcher.forward(req, resp);
    }
}
