# Spring Data

## Spring Data Rest Repositories
- Adding this dependency (`spring-boot-starter-data-rest`) instantly exposes a basic REST API based on your existing
  data repositories
- Base path for generated REST API: `spring.data.rest.base-path=api/rest`

## Spring Data
- JpaRepository is built on top of CrudRepository
    - CRUD + flush + saveAndFlush + deleteInBatch + deleteAllInBatch
- Simple Query Method Property Expression Rules 
    1. Return `type`
    2. start with `findBy` (?)
    3. include attribute name of Java obj (camel case)
        - Ex: `findByAge`
    4. Optionally, chain subattribute names
        - Ex: `findByAttendeeLastName`
        - Where attendee is an object on the Student class
    - Examples found in `university` module `QueryDemos`
    

