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
    public List<BmiData> getBmiList() {
        return bmiDataList;
    }

    @Override
    public BmiData getLastBmi() {

        try {
            return bmiDataList.get(bmiDataList.size() - 1);
        } catch (Exception e) {
            return null;
        }
    }

}
