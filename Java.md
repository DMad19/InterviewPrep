### Q1 Features of Java
   1. Object oriented -> It supports classes and objects
   2. Platform independent -> write once run anywhere
   3. Robust & Secure → Strong type checking, garbage collection, no explicit pointers
   4. Multithreaded → Built-in thread support.
   5. Portable → Bytecode runs on any JVM.
   6. High Performance → JIT compiler optimizes execution
   
### Q2 Difference between == and .equals()
   == check if two references point to the same object where as .equals checks if the two references are equal in content

### Q3 Difference between abstract class and interface

    | Feature               | Abstract Class | Interface         |
    |-----------------------|----------------|-------------------|
    | Code reuse            | ✅ Yes         | ❌ No             |
    | Holds state           | ✅ Yes         | ❌ No             |
    | Multiple inheritance  | ❌ No          | ✅ Yes            |
    | Constructors          | ✅ Yes         | ❌ No             |
    | Default methods       | ✅ Yes         | ✅ (Java 8+)      |

### Q4 Difference between final, finally, and finalize()

        | Keyword     | Type     | Purpose                                                                                |
        |-------------|----------|---------------------------------------------                                           |
        | `final`     | Modifier | Prevents changes: marks variables as constants, methods as non-overridable, classes as non-extendable |
        | `finally`   | Block    | Ensures cleanup code runs always, whether an exception is thrown or not |
        | `finalize()`| Method   | Called by the Garbage Collector before object destruction (deprecated since Java 9) |

### Q5 Explain collections heirarchy

                        Iterable
                            ^
                            |
                            |
                        Collection
                            ^
                            |
                            |
            ----------------------------------------
            ^               ^                       ^
            |               |                       |
            |               |                       |
           List           Queue                    Set<-------------
            ^               ^ ^                     ^               '
            '               | '                     |               '-hashset
            '-arraylist     | priority queue        |               '
            '               Deque                   |               '
            '-linkedlist----^                    Sorted Set         '-linked hashset
            '               '                       ^
            '-vector        '                       '
                ^           ArrayDeque              '
                |                                 Tree Set
              stack

### Q6 Difference between hashmap, hashtable and concurrent hashmap

| Feature                   | HashMap               | Hashtable              | ConcurrentHashMap         |
|---------------------------|-----------------------|------------------------|----------------------------|
| Thread Safety             | ❌ Not synchronized    | ✅ Fully synchronized   | ✅ Concurrent-safe         |
| Performance (multi-threaded) | ⚡ Fast (single-threaded) | 🐢 Slow (locks entire map) | ⚡⚡ Fast (fine-grained locking) |
| Null Keys/Values          | ✅ Allows one null key and multiple null values | ❌ No null keys/values | ❌ No null keys/values     |
| Legacy Status             | ✅ Modern              | ❌ Legacy (pre-Java 1.2)| ✅ Modern (Java 5+)        |


### Q7 Difference Between ArrayList and LinkedList

| Feature                     | ArrayList                          | LinkedList                          |
|-----------------------------|-------------------------------------|--------------------------------------|
| Internal Structure          | Dynamic array                      | Doubly linked list                   |
| Access Time (get/index)     | ✅ Fast (O(1))                      | ❌ Slow (O(n))                       |
| Insert/Delete (middle)      | ❌ Slow (shifting required)         | ✅ Fast (no shifting)                |
| Memory Usage                | ✅ Compact (array overhead only)    | ❌ Higher (node objects + pointers)  |
| Iteration Performance       | ✅ Better cache locality            | ❌ Slower due to pointer chasing     |
| Use Case                    | Best for frequent access by index  | Best for frequent insert/delete ops  |

### Q8 Difference Between Checked and Unchecked Exceptions

| Feature                    | Checked Exception                     | Unchecked Exception                   |
|----------------------------|----------------------------------------|----------------------------------------|
| Package                   | `java.lang.Exception` (excluding `RuntimeException`) | `java.lang.RuntimeException` and its subclasses |
| Compile-Time Enforcement  | ✅ Must be declared or handled         | ❌ Not required to be declared or caught |
| Typical Use Cases         | File I/O, SQL, network operations      | Null pointer, array index out of bounds, illegal arguments |
| Handling Requirement      | Mandatory `try-catch` or `throws`     | Optional handling                      |
| Examples                  | `IOException`, `SQLException`         | `NullPointerException`, `IllegalArgumentException` |

---

## Q9 Difference Between `throw` and `throws` in Java

| Feature               | `throw`                                | `throws`                                 |
|-----------------------|-----------------------------------------|-------------------------------------------|
| Purpose               | Used to **explicitly throw** an exception | Used to **declare** that a method may throw an exception |
| Usage Location        | Inside method body                      | In method signature                        |
| Followed By           | An instance of `Throwable` (e.g., `new Exception()`) | One or more exception class names         |
| Control Flow Impact   | Immediately terminates execution and jumps to nearest catch block | Alerts caller to handle or propagate exception |
| Example               | `throw new IOException("File not found");` | `public void readFile() throws IOException` |

---
