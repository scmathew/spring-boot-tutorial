# Spring Security
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