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
  
## Command Line Runner
- When you want a small body of work deployed as a task
- You can run it as standalone spring app or run it as part of another spring
boot app
- `ApplicationRunner` similar