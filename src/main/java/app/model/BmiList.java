package app.model;

import app.entities.BmiData;


public interface BmiList {
    Object[] BmiArray();

    void add(BmiData bmiData);

}
