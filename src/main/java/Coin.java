public abstract class Coin implements ICalculate{

  abstract double getValue();

  @Override
  public double calculate(double value) {
    return value;
  }
}
