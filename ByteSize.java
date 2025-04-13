public class ByteSize extends Token {
  private final double bytes;

  public ByteSize(String value) {
    super("BYTE_SIZE", value);
    this.bytes = parseToBytes(value);
  }

  private double parseToBytes(String value) {
    value = value.toUpperCase();
    double number = Double.parseDouble(value.replaceAll("[A-Z]+", ""));
    if (value.endsWith("KB")) return number * 1024;
    if (value.endsWith("MB")) return number * 1024 * 1024;
    if (value.endsWith("GB")) return number * 1024 * 1024 * 1024;
    return number;
  }

  public double getBytes() {
    return bytes;
  }
}
