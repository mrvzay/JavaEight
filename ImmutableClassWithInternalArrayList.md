# Designing an Immutable Class with Internal ArrayList

Here's how to properly create an immutable class that uses an ArrayList internally while maintaining immutability guarantees:

## Key Principles for Immutability

1. **No setters/modifiers** - Only allow construction-time initialization
2. **Defensive copying** - Protect against external modifications
3. **Final fields** - Prevent reassignment
4. **No leakage of mutable state** - Never return the internal ArrayList directly

## Implementation Example

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableLibrary {
    private final List<String> books;  // Final reference
    
    // Constructor with defensive copy
    public ImmutableLibrary(List<String> initialBooks) {
        // Create a new ArrayList from the input (defensive copy)
        this.books = new ArrayList<>(initialBooks);
    }
    
    // Getter returns unmodifiable view
    public List<String> getBooks() {
        return Collections.unmodifiableList(books);
    }
    
    // Derived property (immutable operation)
    public int getBookCount() {
        return books.size();
    }
    
    // "Modification" returns new instance
    public ImmutableLibrary withAddedBook(String newBook) {
        List<String> newBooks = new ArrayList<>(this.books);
        newBooks.add(newBook);
        return new ImmutableLibrary(newBooks);
    }
    
    // "Modification" returns new instance with filtered collection
    public ImmutableLibrary withRemovedBook(String bookToRemove) {
        List<String> newBooks = new ArrayList<>(this.books);
        newBooks.remove(bookToRemove);
        return new ImmutableLibrary(newBooks);
    }
}
```

## Usage Example

```java
List<String> initial = new ArrayList<>();
initial.add("Clean Code");
initial.add("Design Patterns");

ImmutableLibrary library = new ImmutableLibrary(initial);

// Attempting to modify the original list doesn't affect our class
initial.add("Hacked!");  // Doesn't change library.books

// Getter provides read-only access
List<String> books = library.getBooks();
try {
    books.add("Another Hack!");  // Throws UnsupportedOperationException
} catch (UnsupportedOperationException e) {
    System.out.println("Expected - list is immutable!");
}

// Safe "modification" through new instances
ImmutableLibrary biggerLibrary = library.withAddedBook("Domain-Driven Design");
```

## Advanced Considerations

1. **Deep Immutability** (if storing mutable objects):
```java
// For mutable elements, return defensive copies
public List<Book> getBooks() {
    return books.stream()
                .map(Book::copy)  // Assuming Book has a copy method
                .collect(Collectors.toUnmodifiableList());
}
```

2. **Performance Optimization** (for frequent copies):
```java
// Reuse internal array when safe (Java 10+)
public ImmutableLibrary withAddedBook(String newBook) {
    return new ImmutableLibrary(Stream.concat(books.stream(), Stream.of(newBook))
                                    .collect(Collectors.toList()));
}
```

3. **Thread Safety**:
```java
// Immutable objects are inherently thread-safe
public class ImmutableLibrary {
    // No synchronization needed - all state is final
}
```

## Why This Works

1. **Construction**: Makes a defensive copy of the input list
2. **Storage**: Keeps the internal list private and final
3. **Access**: Returns only unmodifiable views or copies
4. **Modification**: All "changes" return new instances

This pattern is used in many Java libraries (e.g., `java.lang.String`, `java.time` classes) and follows effective immutable object design principles.
