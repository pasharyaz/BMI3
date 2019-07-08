package app.model;

import app.entities.BmiData;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;


public class BmiListImpl implements BmiList {
    private List<BmiData> bmiDataList;

    @Inject
    public BmiListImpl() {
        this.bmiDataList = new ArrayList<>();
    }


    @Override
    public void add(BmiData bmiData) {
        bmiDataList.add(bmiData);
    }

    @Override
    public Object[] BmiArray() {
        return bmiDataList.toArray();
    }
}
