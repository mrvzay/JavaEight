The `java.time` package introduced in Java 8 provides a rich set of classes and methods for handling dates, times, and durations. Below are some of the **most frequently used methods** in real-time scenarios, along with code examples:

---

### **1. `LocalDate`**
Represents a date without time or time zone.

#### Common Methods:
- `now()`: Gets the current date.
- `of(int year, int month, int dayOfMonth)`: Creates a specific date.
- `plusDays(long days)`, `minusDays(long days)`: Adds or subtracts days.
- `isBefore(LocalDate other)`, `isAfter(LocalDate other)`: Compares dates.
- `format(DateTimeFormatter formatter)`: Formats the date.

#### Example:
```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
    public static void main(String[] args) {
        // Get current date
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today); // Output: 2023-10-25

        // Create a specific date
        LocalDate independenceDay = LocalDate.of(1947, 8, 15);
        System.out.println("Independence Day: " + independenceDay); // Output: 1947-08-15

        // Add 10 days to today
        LocalDate futureDate = today.plusDays(10);
        System.out.println("Future Date: " + futureDate); // Output: 2023-11-04

        // Compare dates
        if (today.isBefore(futureDate)) {
            System.out.println("Today is before the future date.");
        }

        // Format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter);
        System.out.println("Formatted Date: " + formattedDate); // Output: 25/10/2023
    }
}
```

---

### **2. `LocalTime`**
Represents a time without a date or time zone.

#### Common Methods:
- `now()`: Gets the current time.
- `of(int hour, int minute, int second)`: Creates a specific time.
- `plusHours(long hours)`, `minusMinutes(long minutes)`: Adds or subtracts time.
- `isBefore(LocalTime other)`, `isAfter(LocalTime other)`: Compares times.

#### Example:
```java
import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        // Get current time
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now); // Output: 14:30:45.123

        // Create a specific time
        LocalTime meetingTime = LocalTime.of(15, 30, 0);
        System.out.println("Meeting Time: " + meetingTime); // Output: 15:30:00

        // Add 2 hours to the current time
        LocalTime laterTime = now.plusHours(2);
        System.out.println("Later Time: " + laterTime); // Output: 16:30:45.123

        // Compare times
        if (now.isBefore(meetingTime)) {
            System.out.println("Meeting has not started yet.");
        }
    }
}
```

---

### **3. `LocalDateTime`**
Represents a date and time without a time zone.

#### Common Methods:
- `now()`: Gets the current date and time.
- `of(int year, int month, int dayOfMonth, int hour, int minute)`: Creates a specific date and time.
- `plusDays(long days)`, `minusHours(long hours)`: Adds or subtracts time.
- `format(DateTimeFormatter formatter)`: Formats the date and time.

#### Example:
```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + now); // Output: 2023-10-25T14:30:45.123

        // Create a specific date and time
        LocalDateTime eventDateTime = LocalDateTime.of(2023, 12, 25, 18, 0);
        System.out.println("Event Date and Time: " + eventDateTime); // Output: 2023-12-25T18:00

        // Add 1 week to the current date and time
        LocalDateTime nextWeek = now.plusWeeks(1);
        System.out.println("Next Week: " + nextWeek); // Output: 2023-11-01T14:30:45.123

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime); // Output: 25-10-2023 14:30:45
    }
}
```

---

### **4. `ZonedDateTime`**
Represents a date and time with a time zone.

#### Common Methods:
- `now(ZoneId zone)`: Gets the current date and time in a specific time zone.
- `of(LocalDateTime localDateTime, ZoneId zone)`: Creates a specific date and time with a time zone.
- `withZoneSameInstant(ZoneId zone)`: Converts to another time zone.

#### Example:
```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        // Get current date and time in the system's default time zone
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Current Date and Time: " + now); // Output: 2023-10-25T14:30:45.123+02:00[Europe/Paris]

        // Get current date and time in a specific time zone
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("New York Time: " + newYorkTime); // Output: 2023-10-25T08:30:45.123-04:00[America/New_York]

        // Convert to another time zone
        ZonedDateTime tokyoTime = now.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Tokyo Time: " + tokyoTime); // Output: 2023-10-25T21:30:45.123+09:00[Asia/Tokyo]
    }
}
```

---

### **5. `Duration` and `Period`**
- **`Duration`**: Represents a time-based amount of time (e.g., hours, minutes, seconds).
- **`Period`**: Represents a date-based amount of time (e.g., years, months, days).

#### Example:
```java
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.LocalDate;

public class DurationPeriodExample {
    public static void main(String[] args) {
        // Duration example
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 30);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Duration: " + duration.toHours() + " hours"); // Output: 8 hours

        // Period example
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 10, 25);
        Period period = Period.between(startDate, endDate);
        System.out.println("Period: " + period.getMonths() + " months and " + period.getDays() + " days"); // Output: 9 months and 24 days
    }
}
```

---

### **6. `DateTimeFormatter`**
Used for formatting and parsing dates and times.

#### Example:
```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime); // Output: 25-10-2023 14:30:45
    }
}
```

---

### **Real-Time Scenarios**
1. **Event Scheduling**: Use `LocalDateTime` and `ZonedDateTime` to schedule events across time zones.
2. **Age Calculation**: Use `Period` to calculate the difference between two dates (e.g., age).
3. **Time-Based Calculations**: Use `Duration` to calculate the difference between two times (e.g., working hours).
4. **Date Formatting**: Use `DateTimeFormatter` to display dates and times in user-friendly formats.

The `java.time` API is versatile and well-suited for modern date and time handling in Java applications.
