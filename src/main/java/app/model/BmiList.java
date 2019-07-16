package app.model;

import app.entities.BmiData;

import java.util.List;


public interface BmiList {
    List<BmiData> getBmiList();

    void add(BmiData bmiData);

    BmiData getLastBmi();

}
