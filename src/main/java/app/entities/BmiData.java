package app.entities;

public interface BmiData {
    void setWeight(String weight);

    String getWeight();

    String getHeight();

    void setHeight(String height);

    void setBmi();

    double getBmi();

    String getBmiResult();

    void setBmiResult();
}
