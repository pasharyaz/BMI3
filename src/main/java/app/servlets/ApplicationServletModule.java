package app.servlets;

import com.google.inject.servlet.ServletModule;

public class ApplicationServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(SubmitServlet.class);

        serve("/BMI.jsp").with(SubmitServlet.class);
    }
}
