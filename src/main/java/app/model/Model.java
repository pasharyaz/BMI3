package app.model;

import app.entities.BmiDataImpl;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model ourInstance = new Model();

    private List<BmiDataImpl> model;

    public static Model getInstance() {
        return ourInstance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(BmiDataImpl bmiDataImpl) {
        model.add(bmiDataImpl);
    }


    public Object[] arrayBMI() {
        return model.toArray();
    }


}
