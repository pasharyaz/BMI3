package app.model;

import app.entities.BmiData;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model ourInstance = new Model();

    private List<BmiData> model;

    public static Model getInstance() {
        return ourInstance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(BmiData bmiData) {
        model.add(bmiData);
    }


    public Object[] arrayBMI() {
        return model.toArray();
    }


}
