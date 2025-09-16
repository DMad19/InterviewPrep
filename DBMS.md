# DBMS

# Components of Database
1. Hardware - Your system
2. Software - dbms - mysql, microsoft sql server
3. Language - sql, oracle pl/sql etc.,
4. data - the real data
5. procedures - rules (who to access and who to not)
6. users - devs, dba etc.,

# Types of DBMS
1. SQL - tables ( rows and columns)
2. NoSQL - docs, json etc., (for large data and easy to scale)
3. OODBMS
4. Heirarchical DBMS (single parent)
5. Network DBMS (multi parent)
6. Cloud DBMS (AWS RDS)

# Database Languages
1. Data Definition Language - define - create, alter, drop, truncate, comment, rename
2. Data Manipulation Language - manupulate - select, insert, update, delete, merge, call, explain plan, lock table
3. Data Control Language - control - Grant, Revoke
4. Transaction Control Language - Transaction - Rollback, commit, savepoint
5. DQL - query - subset of DML - select

# DBMS Architecture
1. Tier-1 (user and dbms in the same machine)
2. Tier-2 (user and dbms in the different machines and user trying to acces directly. multiple users-> multiple connections)
3. Tier-2 (user and dbms in the different machines. Application server is the intermediate layer. multiple users -> application server -> dbms. single connection)

# ER Models
conceptual model for designing databases.
## Tells three things:
1. Entities (tables)
2. Attributes (columns)
3. Relationships (relation between tables)

## Symbols in the ER Model
1. Rectangles - entities
2. Ellipses - attibutes
3. Diamonds - relationship between different entities
4. Line - To map attributes to entities
5. Double Ellipse - multivalued attibutes
6. Double Rectangle - weak entity (can't identify it on it's own attributes)

## Entities 
### Real world objects, things, concepts
### Types
1. Strong entity(can exist on it's own) eg. player
2. Weak entity(cannot exist on it's own) eg. player_records (can't exist without player)

## Attributes
### properties that define entity type
### Types
1. Key Attribute (unique identifier that identify the entity in the entity set) (represented with underline)
2. Composite Attribute (An attribute composed of many other attributes)
3. Mutlivalued Attribute (can have multiple values)(double ellipse)
4. Derived attribute (Age derived from the dob)(dotted ellipse)

## Relationships
### Degree of Relationship set
#### No of different entities participating in the relationship is called the degree of the relationship set
#### Types
1. Unary(1 entity)
2. Binary(2 entities)
3. Ternary(3 entities)
4. n-ary(n entities)
#### Cardinality
##### Max number of times an entity in entity set participates in a relationship is called cardinality
1. one to one
2. one to many
3. many to one
4. many to many
#### Participation
##### Types
1. Total participation (entity must participate in the relationship. Represented by double line in the er diagram)
2. Partial participation (entity may or may not participate)

#### Structural Constraints
##### Nothing but cardinality + participation
###### Will be represented in the (min,max) pairs
eg. Book (0,1)  —— Borrowed_By ——  (0,5) Member  
Book side: (0,1) → partial participation, one book max to one member.  
Member side: (0,5) → partial participation, member can borrow up to 5 books.  

## Generalisation, Specialization and Aggregation
### Generalisation
It's bottom up approach  
When There are common attributes in the entities, we can create a new entity with those common attributes to reduce the redundancy

## Specialization
It's top down approach  
When we need to divide the main entity to sub entities. We can use this technique to reduce the null values in the rows and make it normalized.  

## Aggregation
Treating relationship like an entity if needed.

## Relational Model
It organises data in structured way. It represents data in rows and columns called as tables, also called as relations.
### Terminologies
Relations - Tables  
Relational Schema - Structure of a Relation / Table  
Relational Instance - Set of values in a relationship at a particular instance of time  
Attributes - Columns / Properties in a Relation / Table  
Domain of a Attribute - Possible values a attribute can take  
Tuple - Each row of a relationship is called tuple  
Cardinality - Number of Distinct values in a column of a table  
Degree - Number of columns in a table  
Primary key - The attribute that can be used to uniquely identify a tuple/row in a relation/table.

### Relational Algebra
set of operations that can be performed on relations / tables  

#### UNION
It's combination of two relations with removed duplicates. Should have same columns/same datatype columns to apply union between two tables. (A U B)

#### INTERSECTION
It's common of two relations. (A ∩ B)

#### DIFFERENCE
It gives elements in first relation and not in second. (A - B)

#### CARTESIAN PRODUCT
It gives all the combinations of A and B. It's nothing but each row from table A paired with each row from table B. (A * B)

#### SELECT
Subset of tuples in a relation which satisfies given conditions. (σ A)

#### PROJECTION
Specified columns in a relation which satiesfies given conditions. (π(col1,col2…) A)

#### JOINS
It combines two or more relations / tables. There are mainly 4 types  
1. Inner Join
2. Outer Join
3. Left Outer Join
4. Right Outer Join

#### DIVIDE
From relation A (which has two attributes, say X and Y), find all X values that are associated with all Y values in B. (A / B)  
Suppose we want: Which employees perform all required roles?

##### A (EmployeeRoles: Emp → Role)  
Emp     Role  
Alice	Clerk  
Alice	Manager  
Bob	    Clerk  
Bob	    Manager  
Bob	    Salesman  
Charlie	Clerk  

###### B (RequiredRoles)
Role
Clerk
Manager

A/B gives the employees who have the role as both clerk and manager.  
Result = {Alice, Bob}

#### RENAME
It changes the name of the relation. ρ(OLD RELATION, NEW RELATION)  

### Codd's Twelve Rules of Relational Database
E.F. Codd gave 12 rules basically to check whether DBMS have quality to become RDBMS.  
But, it is rare to find that any product has fulfilled all the rules of Codd. They generally follow the 8-9 rules of Codd. E.F. Codd has proposed 13 rules which are popularly known as Codd's 12 rules.  

* Rule 0: Foundation Rule- For any system that is advertised as, or claimed to be, a relational database management system, that system must be able to manage databases entirely through its relational capabilities.
* Rule 1: Information Rule- Data stored in the Relational model must be a value of some cell of a table.
* Rule 2: Guaranteed Access Rule- Every data element must be accessible by the table name, its primary key, and the name of the attribute whose value is to be determined.
* Rule 3: Systematic Treatment of NULL values- NULL value in the database must only correspond to missing, unknown, or not applicable values.
* Rule 4: Active Online Catalog- The structure of the database must be stored in an online catalog that can be queried by authorized users.
* Rule 5: Comprehensive Data Sub-language Rule- A database should be accessible by a language supported for definition, manipulation, and transaction management operation.
* Rule 6: View Updating Rule- Different views created for various purposes should be automatically updatable by the system.
* Rule 7: High-level insert, update and delete rule- Relational Model should support insert, delete, update, etc. operations at each level of relations. Also, set operations like Union, Intersection, and minus should be supported.
* Rule 8: Physical data independence- Any modification in the physical location of a table should not enforce modification at the application level.
* Rule 9: Logical data independence- Any modification in the logical or conceptual schema of a table should not enforce modification at the application level. For example, merging two tables into one should not affect the application accessing it which is difficult to achieve.
* Rule 10: Integrity Independence- Integrity constraints modified at the database level should not enforce modification at the application level.
* Rule 11: Distribution Independence- Distribution of data over various locations should not be visible to end-users.
* Rule 12: Non-Subversion Rule- Low-level access to data should not be able to bypass the integrity rule to change data.