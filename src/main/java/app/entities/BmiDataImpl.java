package app.entities;


import com.google.inject.Inject;

public class BmiDataImpl implements BmiData {

    private String height;
    private String weight;
    private double bmi;
    private String bmiResult;

    @Inject
    public BmiDataImpl(String height, String weight) {
        this.height = height;
        this.weight = weight;

        setBmi();
        setBmiResult();
    }

    @Override
    public String getWeight() {
        return weight;
    }

    @Override
    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String getHeight() {
        return height;
    }

    @Override
    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public void setBmi() {
        double height2 = parseNumber(this.height) / 100;
        double weight2 = parseNumber(this.weight);
        this.bmi = height2 > 0 ? ((weight2) / (height2 * height2)) : 0;
    }

    @Override
    public double getBmi() {
        return bmi;
    }

    @Override
    public String getBmiResult() {
        return bmiResult;
    }

    @Override
    public void setBmiResult() {
        if (this.bmi <= 0) {
            bmiResult = "Неправильный формат числа";
        } else if (this.bmi > 0 && this.bmi <= 16) {
            bmiResult = "Срочно в мак";
        } else if (this.bmi > 16 && this.bmi <= 18.5) {
            bmiResult = "надо бы поесть";
        } else if (this.bmi > 18.5 && this.bmi <= 25) {
            bmiResult = "норма";
        } else if (this.bmi > 25 && this.bmi <= 30) {
            bmiResult = "перебор";
        } else if (this.bmi > 30 && this.bmi <= 35) {
            bmiResult = "надо худеть";
        } else if (this.bmi > 35 && this.bmi <= 40) {
            bmiResult = "если честно, даже Земле тяжеловато";
        } else {
            bmiResult = "Вернись обратно держать Землю, пожалуйста, оставшимся двум слонам тяжеловато";
        }
    }

    private double parseNumber(String number) {
        if (!number.isEmpty()) {
            try {
                if (Double.parseDouble(number) > 0) {
                    return Double.parseDouble(number);
                } else return 0;
            } catch (NumberFormatException e) {
                return 0;
            }
        } else return 0;

    }

    @Override
    public String toString() {
        return String.format("%.1f", this.getBmi()) + " - " + this.getBmiResult();
    }


}
