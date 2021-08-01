import java.io.Serializable;

public class EUR extends Coin implements Serializable {
    final double value = 0.26;
    double input;

    @Override
    double getValue() {
        return value;
    }

    @Override
    public double calculate(double input) {
        return input * getValue();
    }

    public void setInput(double input) {
        this.input = input;
    }
}
