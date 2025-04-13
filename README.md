

```markdown
# CDAP Wrangler Enhancement

This repository contains an enhancement to the [CDAP Wrangler](https://github.com/data-integrations/wrangler) project. It introduces support for parsing and aggregating byte sizes and time durations through new directives and updated grammar.

## 🚀 Features

- New Grammar Support: Enhanced directive grammar to recognize byte and time units.
- Custom Token Parsers: Added `ByteSize` and `TimeDuration` token types to simplify unit conversion.
- Directive Enhancement: Introduced `AggregateStats` directive to process and summarize byte size and time columns.
- Unit & Integration Testing: Ensured functionality with a comprehensive test suite.
- Developer Prompts: Added `prompts.txt` to support AI-assisted development.

---

## 📁 Project Structure

### 1. Grammar Updates (`Directives.g4`)
- Lexer Additions: Added support for byte and time units via `BYTE_UNIT`, `TIME_UNIT`.
- Parser Rules: Introduced `byteSizeArg` and `timeDurationArg`.
- Recompilation: Regenerated using `mvn clean compile`.

### 2. API Additions (`wrangler-api`)
- `ByteSize.java`:
  Converts strings like `10KB`, `1.5MB` into corresponding byte values.
- `TimeDuration.java`:
  Converts time expressions like `200ms`, `2s` into milliseconds.
- `TokenType.java`:
  Integrated `BYTE_SIZE` and `TIME_DURATION` token types.

### 3. Core Parser Enhancements (`wrangler-core`)
- Enhanced visitor pattern to handle new token classes.
- Returned appropriate instances of `ByteSize` and `TimeDuration`.

### 4. New Directive: `AggregateStats`
- Aggregates values from two columns (byte size and duration).
- Outputs:
  - Total Size in **MB**
  - Total Duration in **Seconds**

---

## 🧪 Test Coverage

### Unit Tests
- **Byte Size Parsing**
- **Time Duration Parsing**

### Integration Test
- **AggregateStats Directive**:
  Validates row-level aggregation and output correctness.

```java
@Test
public void testAggregateStatsDirective() {
    List<Row> rows = Arrays.asList(
        new Row().add("data_transfer_size", new ByteSize("2MB")).add("response_time", new TimeDuration("1s")),
        new Row().add("data_transfer_size", new ByteSize("3MB")).add("response_time", new TimeDuration("2s"))
    );
    List<Row> result = new AggregateStats().execute(rows, null);
    assertEquals(5.0, result.get(0).getValue("total_size_mb"), 0.001);
    assertEquals(3.0, result.get(0).getValue("total_time_sec"), 0.001);
}
```

---

## 📜 Usage

To use the new `AggregateStats` directive:

```wrangler
aggregate-stats data_transfer_size response_time total_size_mb total_time_sec
```

## 🧠 AI Support

This project includes a `prompts.txt` file to support AI code generation and debugging. It can be used with tools like GitHub Copilot or ChatGPT to assist in further development.

---

## 📄 Supported Units

| Byte Units | Time Units |
|------------|------------|
| KB, MB, GB | ms, s      |

---

## ✅ How to Run

1. **Fork this repo**.
2. **Clone it** locally:
   ```bash
   git clone https://github.com/your-username/wrangler-enhancement.git
   cd wrangler-enhancement
   ```
3. **Build the project**:
   ```bash
   mvn clean compile
   ```
4. **Run Tests**:
   ```bash
   mvn test
   ```

---

## 📧 Contact

For any queries or contributions, feel free to raise an issue or open a pull request.

---

```

Let me know if you want me to also generate a `prompts.txt` file or organize this into an actual Git repo structure for submission.
