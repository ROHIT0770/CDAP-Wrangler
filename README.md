# CDAP Wrangler Enhancement - ByteSize & TimeDuration Parsers

This project enhances the CDAP Wrangler library by adding built-in support for parsing and aggregating byte sizes (e.g., KB, MB) and time durations (e.g., ms, s).

## Features
- New Token Types: `BYTE_SIZE`, `TIME_DURATION`
- New Java Classes: `ByteSize.java`, `TimeDuration.java`
- Aggregate Directive: `aggregate-stats` for computing total/average of data size and time
- Full test coverage and validation

## Usage Example
