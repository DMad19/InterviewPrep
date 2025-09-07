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