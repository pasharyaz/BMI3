package app.model;

import app.entities.BmiData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model ourInstance = new Model();

    private List<BmiData> model;

    public static Model getInstance() {
        return ourInstance;
    }

    private Model() {
        model = new ArrayList<BmiData>();
    }

    public void add(BmiData bmiData) {
        model.add(bmiData);
    }

    public List<Double> listBmi() {
        return model.stream()
                .map(BmiData::getBmi)
                .collect(Collectors.toList());
    }

    public List<String> listResult() {
        return model.stream()
                .map(BmiData::getBmiResult)
                .collect(Collectors.toList());
    }

    public Object[] arrayBMI() {
        return model.toArray();
    }



}
