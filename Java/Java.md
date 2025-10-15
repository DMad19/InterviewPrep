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

## Q10 What are functional interfaces

A Functional Interface in Java 8 is an interface that has exactly one abstract method.  
It represents a single functionality that can be used as a Lambda Expression or Method Reference.  
Java provides many built-in functional interfaces under java.util.function like:  
1. Predicate<T> → returns boolean
2. Function<T, R> → transforms input to output
3. Consumer<T> → takes input and performs an action
4. Supplier<T> → returns a value without input  

Example:  

    @FunctionalInterface  
    interface Greeting {  
        void sayHello();  
    }  
  
  
And we can implement it as:  

Greeting g = () -> System.out.println("Hello!");
g.sayHello();

## Q11 Difference between Stream API and Collections API

Collections are used to store and manage data, while Streams are used to process data in a functional style.  
Collections are eager — they store all elements in memory.  
Streams are lazy — they process elements on-demand through a pipeline of operations like filter, map, and reduce.  
Also, Streams don’t modify the original data; they return a new stream.  
Streams can even run parallel operations easily, improving performance on large datasets.  

## Q12 What is Optional Class in Java

Optional is a container object introduced in Java 8 to handle null values safely and avoid NullPointerException.  
Instead of returning null, methods can return an Optional<T>.  
It provides methods like isPresent(), orElse(), and ifPresent() to safely handle values.  

## Q13 How does Synchronization work in Java

Synchronization is Java’s way of controlling access to shared resources in multi-threaded environments. It ensures that only one thread can access a block of code or object at a time—preventing race conditions, data corruption, and inconsistent states.  

example:  

    class Counter {  
    
        private int count = 0;  

        public synchronized void increment() {  
            count++;  
        }  

        public synchronized int getCount() {  
            return count;  
        }  
    }  

## Q14 Difference between Volatile and Synchronized Keyword

volatile ensures that all threads see the latest value of a variable (visibility),  
whereas synchronized ensures that only one thread accesses a resource at a time (atomicity + visibility).

| Feature       | `volatile`                            | `synchronized`                                 |
|---------------|----------------------------------------|------------------------------------------------|
| **Type**      | Keyword for variables                  | Keyword for methods/blocks                     |
| **Ensures**   | Visibility only                        | Visibility + Atomicity                         |
| **Locks used**| No                                     | Yes (object/class lock)                        |
| **Performance**| Faster                                | Slower (due to locking overhead)               |
| **Use case**  | Flags, status variables                | Critical sections, shared mutable state        |
| **Example**   | `volatile boolean isRunning;`          | `synchronized void update() { ... }`           |


## Q15 What is Garbage Collection (GC)?

Garbage Collection in Java is the automatic process of reclaiming memory used by objects that are no longer reachable (i.e., no active reference is pointing to them).  

✅ Without GC, developers would need to manually free memory (like in C/C++ using free() or delete).  
✅ With GC, Java automatically detects and removes unused objects from the heap memory.  

Heap Memory:  
  ├── Young Generation  
  │     ├── Eden Space  
  │     └── Survivor Spaces (S0, S1)  
  └── Old Generation  

#### 🧹 Java Garbage Collection (GC) Process

#### 📦 Object Creation
- New objects are allocated in **Eden Space** (Young Generation).

#### 🔄 Minor GC
- Triggered when Eden fills up.
- **Unreachable objects** are discarded.
- **Survivors** move to **Survivor Spaces**.
- After several cycles, long-lived objects are **promoted to Old Generation**.

#### 🧼 Major GC
- Triggered when **Old Generation** fills up.
- Cleans up **long-lived unreachable objects**.
- Typically **slower** than Minor GC.

**By reachability analysis — if no live thread or static reference can reach an object, it's considered garbage.**

## Q16 Explain Java Memory Model

| Memory Area             | Stores                                   | Created              | Destroyed           | Thread Scope             |
| ----------------------- | ---------------------------------------- | -------------------- | ------------------- | ------------------------ |
| **Heap**                | Objects, instance variables              | When JVM starts      | On GC               | Shared among all threads |
| **Stack**               | Local variables, method calls            | When thread starts   | When thread ends    | Per thread               |
| **Metaspace**           | Class metadata, method info              | When class is loaded | When class unloaded | Shared                   |
| **PC Register**         | Address of current executing instruction | Thread start         | Thread end          | Per thread               |
| **Native Method Stack** | Native (C/C++) method calls              | Thread start         | Thread end          | Per thread               |

![Java Memory Model Image](/Java/assets/java_memory_model.png)

## Q17 Explain spring vs spring boot

🧩 1. What is Spring Framework?

Spring Framework is a comprehensive Java framework for building enterprise applications.
It provides features like:

Dependency Injection (DI)

Aspect-Oriented Programming (AOP)

Transaction Management

Spring MVC (web framework)

Integration with ORM tools (Hibernate, JPA)

But… it required a lot of XML configuration and manual setup (like web.xml, dispatcher-servlet.xml, etc.)

⚡ 2. What is Spring Boot?

Spring Boot is a layer built on top of Spring that makes application development faster and easier.

It provides:

Auto-configuration 🧠

Embedded servers (Tomcat, Jetty) 🧱

Starter dependencies ⚙️

Production-ready tools (Actuator, Metrics) 🚀

👉 In short: Spring Boot = Spring Framework + Automation + Defaults + Simplicity.
| Feature            | Spring Framework                     | Spring Boot                              |
| ------------------ | ------------------------------------ | ---------------------------------------- |
| **Setup**          | Requires manual XML/Java config      | Auto-configured setup                    |
| **Server**         | Needs external server (Tomcat/Jetty) | Embedded Tomcat/Jetty                    |
| **Dependencies**   | Must manage versions manually        | Uses “Starters” for grouped dependencies |
| **Configuration**  | Annotation/XML heavy                 | Minimal; uses `application.properties`   |
| **Deployment**     | WAR file deployment                  | Can run directly as JAR (`java -jar`)    |
| **Monitoring**     | Needs manual setup                   | Built-in via Spring Boot Actuator        |
| **Learning Curve** | Steeper                              | Easier for beginners and microservices   |

## Q18 What Are Spring Boot Starters?

🧩 Definition

Spring Boot Starters are predefined dependency bundles provided by Spring Boot to simplify project setup.

Instead of manually adding 10–15 individual dependencies,
you just include one starter, and Spring Boot automatically pulls in everything required.

Example:  

    Let’s say you want to build a Spring Boot REST API.

    Normally (in traditional Spring), you’d add dependencies like:

    spring-core  
    spring-web  
    spring-context  
    jackson-databind  
    servlet-api


    😩 That’s tedious and version-conflict prone.

    With Spring Boot, you just add:

    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    </dependency>


    ✅ Done — it automatically adds:

    spring-boot-starter-web
        ├── spring-web
        │   ├── spring-webmvc
        │   └── spring-websocket
        ├── jackson-databind
        ├── tomcat-embed-core
        └── validation-api

## Q19 Explain Dependency Injection and Inversion Of Control

Inversion of Control (IoC) means:  
The control of object creation and their dependencies is given to a container or framework, not your code.

Dependency Injection is a way to implement IoC. It means:  
Instead of a class creating its own dependencies, they are injected by the container.

IoC Container:  
Spring provides two main IoC Containers.  
BeanFactory — basic container.  
ApplicationContext — advanced container with features like event handling, AOP, and internationalization.  

"Spring uses IoC to manage object creation and lifecycle. I declare dependencies via DI, and the container wires them in. The ApplicationContext is the heart of this system—it scans, instantiates, and injects beans based on configuration or annotations."

## Q20 Explain difference between Component, Service, Repository, Controller and RestController

All four are Spring-managed components, but they serve different roles:
@Component is a generic stereotype  
@Service is for the business layer  
@Repository is for the persistence layer (with exception translation)  
@Controller is for the presentation layer  
@RestController combines @Controller and @ResponseBody for REST APIs.

## Q21 Explain Bean LifeCycle and Bean Scopes.

Bean Lifecycle (Step-by-Step):  

    When you start your Spring app, here’s what happens for each bean:  
    Instantiation → Spring creates an instance of the bean class.  
    Dependency Injection → Dependencies are injected (via constructor/setter/field).  
    @PostConstruct → Any method annotated with this runs after dependencies are injected.  
    Bean is Ready to Use → The application can now use it.  
    @PreDestroy → Runs just before the bean is destroyed (e.g., app shutdown).  
    Garbage Collected → Bean object is removed from memory.  

Spring Bean Scopes in Web Applications:

| Scope               | Description                              | Created                | Example               |
|---------------------|------------------------------------------|------------------------|------------------------|
| `singleton` (default) | One instance per Spring container        | On startup             | Services, Utilities    |
| `prototype`         | New instance every time requested        | On request             | Stateful beans         |
| `request`           | One instance per HTTP request (web-only) | Per HTTP request       | Controllers            |
| `session`           | One per HTTP session (web-only)          | Per user session       | Session data           |
| `application`       | One per servlet context (web-only)       | On servlet startup     | Shared resources       |


## Q22 Explain @SpringBootApplication annotation
| Annotation                 | Role                                                                                                                                                                                 |
| -------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `@Configuration`           | Marks the class as a source of Spring bean definitions.                                                                                                                              |
| `@EnableAutoConfiguration` | Tells Spring Boot to automatically configure beans based on dependencies in the classpath (e.g., if `spring-boot-starter-web` is present → sets up Tomcat, DispatcherServlet, etc.). |
| `@ComponentScan`           | Enables scanning for components (`@Component`, `@Service`, `@Repository`, `@Controller`) in the current package and subpackages.                                                     |

# Q23 What are application.properties / application.yml files used for

The application.properties or application.yml file is used in Spring Boot to externalize configuration.  
It contains environment-specific settings like server port, database details, or custom keys.  
It helps separate code from configuration, making applications easier to manage and deploy.

## Q24 Explain Spring Autoconfiguration

Spring Boot auto-configuration automatically sets up beans based on the libraries in the classpath.  
It’s enabled by @EnableAutoConfiguration, which loads many configuration classes listed under META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports.  
These classes use conditional annotations like @ConditionalOnClass and @ConditionalOnMissingBean to apply sensible defaults — which developers can override in application.properties.  

## Q25 what are profiles in spring boot

Spring Boot profiles allow environment-specific configurations.  
You can define separate property files (like application-dev.properties, application-prod.properties)  
and activate them using spring.profiles.active.  
This helps manage different setups for dev, test, and production environments cleanly.  

## Q26 What is the difference between bean and component
Both @Bean and @Component create Spring-managed beans.  
@Component is used on classes detected through component scanning,  
while @Bean is used inside a @Configuration class to manually define a bean — typically for third-party classes or custom initialization logic.  

## Q27 Explain CommandLineRunner and ApplicationRunner

CommandLineRunner and ApplicationRunner are interfaces in Spring Boot that let you run custom logic after the application starts.  
The difference is that CommandLineRunner takes String... args, while ApplicationRunner provides an ApplicationArguments object for easier argument handling.  
They’re often used for initialization tasks or running startup scripts.  

## Q28 What are Spring Boot Actuators?

Spring Boot Actuator is a powerful production-ready feature that helps you monitor and manage your Spring Boot applications.
It provides built-in endpoints that give insights into the health, metrics, environment, beans, and much more — all without writing extra code.

## Q29 How do you configure logging in Spring Boot?

Spring Boot uses Apache Commons Logging as a facade and delegates to the actual logging implementation—by default, that’s Logback.
✅ Default Setup  
Logback is auto-configured.  
Logs go to console and optionally to files.  
Configurable via application.properties or logback-spring.xml.  

## Q30 Explain externalised configuration in spring
In Spring Boot, externalized configuration means
you can keep configuration outside your code —
so you can change values without rebuilding or redeploying your app.

| Priority | Source                                                  | Description                                      |
|----------|---------------------------------------------------------|--------------------------------------------------|
| 1        | `application.properties` / `application.yml` inside JAR | Default config bundled with the app              |
| 2        | Profile-specific file (e.g., `application-dev.yml`)     | Overrides base config for active profile         |
| 3        | Command-line arguments                                  | Passed via CLI or run config (`--key=value`)     |
| 4        | OS environment variables                                | Set via shell or container environment           |
| 5        | JVM system properties (`-Dkey=value`)                   | Passed via JVM flags                             |
| 6        | External config files (outside the JAR)                 | Mounted or injected files (e.g., `/etc/config`)  |
| 7        | Cloud Config Server or Vault                            | Centralized config for distributed systems       |

## Q31 How do you secure a spring boot application

A secure Spring Boot application applies:

    Authentication to verify users  
    Authorization to control access  
    HTTPS for secure transport  
    Externalized secrets for config safety  
    Infrastructure hardening for runtime protection  
    CSRF/session controls for web security  

## Q32 What is JWT and how we use in Spring Security

1. User logs in with credentials.  
2. If valid → server generates a JWT using JwtUtil.  
3. The token is returned in the response.  
4. The client stores it (e.g., in localStorage or sessionStorage).  
5. For every future request → client sends the token in header:  
    Authorization: Bearer <token>  
6. A JWT filter intercepts the request and validates it before it reaches the controller.

## Q33 Difference between OAuth2 and JWT based authentication

| Aspect               | OAuth2                                           | JWT-Based Authentication                          |
|----------------------|--------------------------------------------------|---------------------------------------------------|
| **Purpose**          | Delegates access to resources via third-party    | Authenticates users directly using signed tokens  |
| **Flow**             | Redirect → Code → Token → User Info              | Login → Issue JWT → Send with each request        |
| **Token Format**     | Can be JWT or opaque                             | Always JWT (JSON Web Token)                       |
| **Authentication Source** | External provider (Google, Azure, etc.)   | Your own backend issues and validates tokens      |
| **Session Handling** | Can be session-based or token-based              | Stateless—no session needed                       |
| **Use Case**         | SSO, delegated access, third-party login         | REST APIs, microservices, mobile clients          |
| **Validation**       | Often requires token introspection or user info | Local validation using signature and expiry       |

## Q34 How does spring connects to databases
1. Spring Boot reads DB config → creates DataSource
2. Hibernate uses DataSource → builds EntityManagerFactory
3. Spring scans for @Entity classes → maps to tables
4. TransactionManager enables @Transactional
5. Spring Data JPA exposes repositories

## Q35 Difference between CRUDRepository, PagingAndSortingRepository, JPARepository

| Feature                                 | CrudRepository | PagingAndSortingRepository | JpaRepository |
| --------------------------------------- | -------------- | -------------------------- | ------------- |
| **Basic CRUD**                          | ✅              | ✅                          | ✅             |
| **Pagination**                          | ❌              | ✅                          | ✅             |
| **Sorting**                             | ❌              | ✅                          | ✅             |
| **Batch Operations**                    | ❌              | ❌                          | ✅             |
| **JPA-specific methods (flush, batch)** | ❌              | ❌                          | ✅             |
| **Most commonly used**                  | 🚫             | 🚫                         | ✅ ✅ ✅         |


## Q36 How do you handle transactions in Spring Boot?
Spring Boot uses Spring Transaction Management, built on top of the @Transactional annotation.

✅ Spring creates a proxy for this method.  
✅ It starts a transaction before executing it.  
✅ If everything succeeds → commits the transaction.  
✅ If an exception occurs → rolls back automatically.  


## Q37 Explain transaction propogation 
| Propagation Type       | Description                                                                  |
| ---------------------- | ---------------------------------------------------------------------------- |
| **REQUIRED** (default) | Join existing transaction if one exists; otherwise create a new one.         |
| **REQUIRES_NEW**       | Always create a new transaction; suspend the existing one if any.            |
| **SUPPORTS**           | Join existing transaction if one exists; otherwise run non-transactionally.  |
| **NOT_SUPPORTED**      | Run non-transactionally; suspend existing transaction if any.                |
| **MANDATORY**          | Must run within an existing transaction; throws exception if none exists.    |
| **NEVER**              | Must run without a transaction; throws exception if a transaction exists.    |
| **NESTED**             | Run within a nested transaction if one exists; otherwise acts like REQUIRED. |


## Q38 Difference between lazyloading and eager loading
When we have relationships between entities (e.g., @OneToMany, @ManyToOne), loading determines when related data is fetched from the database.

⚙️ Eager Loading

    Fetches related entities immediately when the parent entity is loaded.

    Done in a single query or a join query (depending on JPA provider).

    Uses:

    @OneToMany(fetch = FetchType.EAGER)


    Advantage: Data is available immediately without additional queries.

    Disadvantage: Can load unnecessary data → performance overhead.

    Example:
    @Entity
    public class Department {
        @OneToMany(fetch = FetchType.EAGER)
        private List<Employee> employees;
    }


When you load a Department, employees are fetched right away.

⚙️ Lazy Loading

    Fetches related entities only when accessed.

    Default for collections in JPA (@OneToMany, @ManyToMany).

    Uses:

    @OneToMany(fetch = FetchType.LAZY)


    Advantage: Performance-friendly — loads data only when needed.

    Disadvantage: Needs a persistent context → may cause LazyInitializationException if accessed outside transaction/session.

    Example:
    @Entity
    public class Department {
        @OneToMany(fetch = FetchType.LAZY)
        private List<Employee> employees;
    }

When you load a Department, employees are fetched only when you call getEmployees().


## Q39 How will you enable caching in spring boot
In Spring Boot, caching is implemented by enabling @EnableCaching, configuring a cache provider, and annotating service methods with @Cacheable, @CachePut, and @CacheEvict.

@Cacheable

    Used to cache the result of a method.

    @Cacheable(value = "products", key = "#id")
    public Product getProductById(Long id) {
        simulateSlowService(); // simulate delay
        return productRepository.findById(id).orElse(null);
    }


    ✅ The first call fetches from DB and caches result
    ✅ Subsequent calls retrieve from cache

@CachePut

    Updates the cache without skipping the method execution.

    @CachePut(value = "products", key = "#product.id")
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

@CacheEvict

    Removes an entry from the cache.

    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

🧩 Example Flow

    First call to getProductById(1) → DB hit, cache store.

    Second call to getProductById(1) → cache hit (no DB call).

    Call to updateProduct(product) → updates DB and cache.

    Call to deleteProduct(id) → removes DB entry and cache entry.

## Q40 Explain Eureka Server and Spring Cloud Config
In a microservices setup, we use Eureka Server as a service registry. Each service registers itself with Eureka on startup, and other services can discover it dynamically—no need to hardcode URLs. This enables load balancing, fault tolerance, and dynamic scaling. For example, if auth-service wants to call notification-service, it queries Eureka to get the current instance location.

We also use Spring Cloud Config to centralize configuration management. Instead of maintaining separate config files in each service, we store them in a Git repo and serve them via a config server. Each service fetches its environment-specific config at startup. This makes it easy to manage profiles, secrets, and versioned changes across environments like dev, staging, and prod.

Together, Eureka and Spring Cloud Config help us build scalable, maintainable, and cloud-native microservices—where services are loosely coupled, discoverable, and consistently configured.

## Q41 Explain Interservice communication

| Feature            | RestTemplate      | Feign Client            | WebClient        |
| ------------------ | ----------------- | ----------------------- | ---------------- |
| Type               | Imperative        | Declarative             | Reactive         |
| Blocking           | Yes               | Yes                     | No               |
| Ease of Use        | Medium            | Very Easy               | Medium           |
| Eureka Integration | Manual            | Automatic               | Manual           |
| Best For           | Simple REST calls | Most microservice calls | Reactive systems |

## Q42 What is circuit breaker pattern

Think of a circuit breaker in your home’s electrical board ⚙️.  
If too much current flows → the circuit trips → prevents damage.

Similarly, in microservices:

When one service (say Payment Service) is down or slow,

We don’t want other services (like Order Service) to keep calling it again and again — wasting threads & resources.

So, the Circuit Breaker Pattern:

Stops calls to a failing service temporarily to allow recovery and protect other services.

| State              | Meaning                                                |
| ------------------ | ------------------------------------------------------ |
| **Closed**         | Everything is normal. Calls pass through.              |
| **Open**           | Failures exceed threshold → stop calling the service.  |
| **Half-Open**      | Test one or few calls to see if service has recovered. |
| **Back to Closed** | If successful → resume normal operation.               |


## Q43 Asynchronous Communication in Spring Boot

| Type                     | Tool/Pattern               | Use Case                                  |
|--------------------------|----------------------------|-------------------------------------------|
| Inter-service (messaging)| Kafka, RabbitMQ            | Event-driven, decoupled services          |
| Inter-service (reactive) | WebFlux + WebClient        | Non-blocking REST calls                   |
| Internal async           | @Async, CompletableFuture, WebFlux | Background tasks, reactive pipelines |


## Q44 What Is Global Exception Handling?

When something goes wrong in your API (for example, invalid input, null pointer, DB failure, etc.), you don’t want to send messy stack traces or generic 500 errors back to the client.

Instead, we use Global Exception Handling to:

Catch all exceptions in one place

Return a consistent, readable error response

Keep controllers clean

| Concept                                       | Annotation                 | Purpose                               |
| --------------------------------------------- | -------------------------- | ------------------------------------- |
| `@ControllerAdvice` / `@RestControllerAdvice` | Global error handling      | Catch all exceptions app-wide         |
| `@ExceptionHandler`                           | On a method                | Handles specific exception types      |
| `ResponseEntity`                              | Return wrapper             | Includes both body & HTTP status      |
| Custom Exception                              | Extends `RuntimeException` | For meaningful domain-specific errors |


## Q45 How does a typical Spring Boot + React/Angular full stack app flow work?

| Layer    | Technology                   | Purpose                       |
| -------- | ---------------------------- | ----------------------------- |
| UI       | React / Angular              | User interface                |
| API      | Spring Boot (REST)           | Business logic & data serving |
| ORM      | Hibernate / JPA              | Data persistence              |
| Security | JWT / OAuth2                 | Authentication                |
| DB       | MySQL / PostgreSQL / MongoDB | Data storage                  |

## Q46 How do you call a Spring Boot API from the frontend?

Frontend → Backend → Database → Frontend

For example:

    User clicks “Get Products” in React.

    React sends a GET request to Spring Boot → /api/products

    Spring Boot returns JSON list of products.

    React renders the products.

Common Issue: CORS Error

    If you see:

    Access to fetch at 'http://localhost:8080/api/products' from origin 'http://localhost:3000' has been blocked by CORS policy


    It’s because the browser blocks requests to a different origin.

✅ Fix: Enable CORS in Spring Boot.  

🔧 How to Enable CORS in Spring Boot

    Option 1: Annotation-based (per controller)

        @CrossOrigin(origins = "http://localhost:3000")
        @RestController
        public class ProductController { ... }

    Option 2: Global Configuration

        @Configuration
        public class WebConfig implements WebMvcConfigurer {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        }

“Frontend calls backend via HTTP REST API using Axios or Fetch.”

“Responses are in JSON, and state updates the UI.”

“We must enable CORS to allow communication between different origins.”


## Q47 Explain Session vs Token Based Authentication

| Feature              | Session-Based              | Token-Based (JWT)                      |
| -------------------- | -------------------------- | -------------------------------------- |
| **State Management** | Server-side                | Client-side                            |
| **Scalability**      | Low                        | High                                   |
| **Storage**          | Session in memory/Redis    | Token in browser (localStorage/cookie) |
| **Auth Check**       | Session lookup             | Token verification                     |
| **Logout**           | Server invalidates session | Token expires or blacklisted           |
| **Best For**         | Monolithic apps            | REST APIs, Microservices, SPAs         |

## Q48 Ways to Enable CORS in Spring Boot

| Method                         | Scope          | When to Use                       |
| ------------------------------ | -------------- | --------------------------------- |
| `@CrossOrigin`                 | Per controller | Small apps, specific APIs         |
| `WebMvcConfigurer`             | Global         | Moderate-sized apps               |
| `CorsFilter + Spring Security` | Full app       | Apps with authentication/security |

## Q49 What are best practices for REST API design?

“When designing REST APIs, I follow a set of best practices to ensure clarity, scalability, and maintainability. These practices help teams onboard faster, reduce bugs, and make integrations predictable.”

🧩 1. Use Meaningful Resource Naming

🧩 2. Follow HTTP Method Semantics

🧩 3. Use Proper Status Codes

🧩 4. Design Consistent Response Structure

🧩 5. Use Versioning

🧩 6. Validate Inputs and Handle Errors Gracefully

🧩 7. Secure Your APIs

🧩 8. Paginate Large Responses

🧩 9. Use HATEOAS (Optional)

## Q50 What's the difference between import and import static

📦 import
Purpose: Brings in classes, interfaces, enums from other packages.

Usage: Lets you refer to types without fully qualifying them.

Example:

    import java.util.List;

    List<String> names = new ArrayList<>();

⚡ import static
Purpose: Brings in static members (fields or methods) from a class.

Usage: Lets you use static methods or constants without class prefix.

Example:

    import static java.lang.Math.PI;
    import static java.lang.Math.pow;

    double area = PI * pow(radius, 2);

## Q51 Can we return the child object for a method which actually returns parent object in the interface?

Yes. 

Example:

    class A {
    }

    class B extends A {
    }

    interface Int {
        A add(); // Method returns A
    }

    class IntImpl implements Int {
        @Override
        public B add() {
            return new B(); // Valid: B is a subclass of A
        }
    }

## Explain Exception Heirarchy in inheritance

If there's method that doesn't throw exception in the parent class and child class throws exception for the same method, that'll give compile time exception. If child wanna throw, parent must and should throw the exception for the same method.

But, It's not mandatory that child method to throw exception if parent throws.

    public class A {
        void hi() throws Exception{
            System.out.println("parent");
        }
    }

    public class B extends A{
        @Override
        void hi(){
            System.out.println("child");
        }

    }
