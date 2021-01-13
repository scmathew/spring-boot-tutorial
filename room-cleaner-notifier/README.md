# Room Cleaner Notifier (Publisher)

Sample Spring Boot project from a LinkedIn Learning course.

When the app is run it puts a message on the topic 
with the routing key `landon.rooms.cleaner` if the `room-web-app`
is running should see log out from that app.

## Build

### Start Spring Boot App via Maven
```bash
 mvn spring-boot:run
```

## Notes
- Rabbit MQ portal can be found at `http://localhost:15672`
