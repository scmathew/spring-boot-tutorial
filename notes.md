# Notes

## Understanding auto-configuration
- `@EnableAutoConfiguration` allows for configuration classes to be scanned dynamically
    - `@SpringBootApplication` includes `@EnableAutoConfiguration`
- Conditional loading allows for configurations to only be loaded when there are classes specifically 
on the class path (`@ConditonalOnClass`, `@ConditionalOnBean`, `@ConditionalOnProperty`, .)
- Pre-configured default properties for auto-config classes (`EnableConfiguratonProperties`). 
Can always be overridden
  
## Configuration in Spring Boot
- `application.properties/yml` only for basic configuration/development
- Typically use env vars
- Cloud Configurations (Config Server, Consul)
- For bean config. Add beans to separate configuration classes or XML based configs or component scanning

## Spring Profiles
- Flex configuration based on environment profile
- Spring Boot provides `.yaml` support natively
- Engage profile via `spring.profiles.active={profile name}`
- If `spring.profiles.active` is empty, then will fallback to default value (Ex: port 8080)

application.yaml example
```yaml
spring:
  profiles: dev
server:
  port: 8000
---
spring:
  profiles: test
server:
  port: 9000
```

## Configuring Embedded Tomcat
- For custom servlets, filters, and listeners add them as beans
- Can configure via properties
  - server.address
  - server.port
  - server.contextPath
  - Session based configs (cookies, timeouts, etc)
  - Error page path
  - Check out `ServerProperties` class
  - server.compression.enabled
  - TLS configuration
  
## Command Line Runner (CLR)
- When you want a small body of work deployed as a task
- You can run it as standalone spring app or run it as part of another spring
boot app
- `ApplicationRunner` similar

## Spring Security
- Can give you basic auth on all endpoints except common ones like /js or /css
  - Just pulling in the basic security dependency does this
  - password printed in log messages (default)
  - mostly for local testing
- Form based authentication
  - default implementation relies on in memory username and passwords?
  - full impl requires creating an extension of WebSecurityConfigurerAdapter and connecting to a db
    - Use `@EnableWebSecurity` - turns off basic auth but enables more configuration
- OAuth2 - support for OAuth2, server, and client
  - `@EnableOAuth2Client`
  - `@EnableAuthorizationServer` - create configurable auth server
  - `@EnableResourceServer` - create configurable resource server
- Passwords
  - Should be hashed not encrypted
  - SHA-1 is beaten
  
## Spring Boot Messaging
- Publisher (Room Cleaner Notifier) and Consumer (room web app - `RoomCleanerListener`, `AsyncConfig`)

## Spring Data Rest Repositories
- Adding this dependency (`spring-boot-starter-data-rest`) instantly exposes a basic REST API based on your existing
  data repositories
- Base path for generated REST API: `spring.data.rest.base-path=api/rest`

## Spring Actuator
- Provides insights into running applications, allows for health checks/monitoring
- health endpoint, simple up/down status
- beans endpoint, info about beans in app
- env endpoint, all env vars
- info endpoint
- metrics endpoint

- Ensure actuator endpoints are not publicly available and only enable the endpoints you need
- Can create new endpoints (room web app - `GreetingEndpoint`)
