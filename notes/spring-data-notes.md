# Spring Data

## Spring Data Rest Repositories
- Adding this dependency (`spring-boot-starter-data-rest`) instantly exposes a basic REST API based on your existing
  data repositories
- Base path for generated REST API: `spring.data.rest.base-path=api/rest`

## Spring Data
- JpaRepository is built on top of CrudRepository
    - CRUD + flush + saveAndFlush + deleteInBatch + deleteAllInBatch
- Simple Query Method Property Expression Rules 
    - Return `type`
    - start with `findBy` (?)
    - include attribute name of Java obj (camel case)
        - Ex: `findByAge`
    - Optionally, chain subattribute names
        - Ex: `findByAttendeeLastName`
        - Where attendee is an object on the Student class
