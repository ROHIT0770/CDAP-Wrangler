public class TimeDuration extends Token {
  private final double millis;

  public TimeDuration(String value) {
    super("TIME_DURATION", value);
    this.millis = parseToMillis(value);
  }

  private double parseToMillis(String value) {
    value = value.toLowerCase();
    double number = Double.parseDouble(value.replaceAll("[a-z]+", ""));
    if (value.endsWith("s")) return number * 1000;
    if (value.endsWith("ms")) return number;
    if (value.endsWith("us")) return number / 1000;
    return number;
  }

  public double getMilliseconds() {
    return millis;
  }
}
