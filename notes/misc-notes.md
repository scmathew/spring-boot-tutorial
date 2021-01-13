# Notes
  
## Command Line Runner (CLR)
- When you want a small body of work deployed as a task
- You can run it as standalone spring app or run it as part of another spring
boot app
- `ApplicationRunner` similar
  
## Spring Boot Messaging
- Publisher (Room Cleaner Notifier) and Consumer (room web app - `RoomCleanerListener`, `AsyncConfig`)

## Spring Actuator
- Provides insights into running applications, allows for health checks/monitoring
  - `localhost:8080/actuator`
- health endpoint, simple up/down status
- beans endpoint, info about beans in app
- env endpoint, all env vars
- info endpoint
- metrics endpoint

- Ensure actuator endpoints are not publicly available and only enable the endpoints you need
- Can create new endpoints (room web app - `GreetingEndpoint`)

## Spring Boot Starter
- Library that can be used across an enterprise for standardized implementation and configuration

