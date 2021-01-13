# Spring Data

## Spring Data Rest Repositories
- Adding this dependency (`spring-boot-starter-data-rest`) instantly exposes a basic REST API based on your existing
  data repositories
- Base path for generated REST API: `spring.data.rest.base-path=api/rest`

## Spring Data
- JpaRepository is built on top of CrudRepository
    - CRUD + flush + saveAndFlush + deleteInBatch + deleteAllInBatch

