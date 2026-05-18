
**Single-Gradle-SpringBoot**

This is a single-module Gradle project built with Spring Boot. It demonstrates a simple user login flow, entity/repository usage, Redis integration, and several utility classes.

Features
- Core app entry: [src/main/java/com/johnny/singlegradlespringboot/SingleGradleApplication.java](src/main/java/com/johnny/singlegradlespringboot/SingleGradleApplication.java)
- Controllers: REST controllers under [src/main/java/com/johnny/singlegradlespringboot/controller](src/main/java/com/johnny/singlegradlespringboot/controller)
- Data layer: repository interfaces under [src/main/java/com/johnny/singlegradlespringboot/repository](src/main/java/com/johnny/singlegradlespringboot/repository)
- Redis support: connection and template configuration in [src/main/java/com/johnny/singlegradlespringboot/redis](src/main/java/com/johnny/singlegradlespringboot/redis)
- Utilities: helper classes under [src/main/java/com/johnny/singlegradlespringboot/utils](src/main/java/com/johnny/singlegradlespringboot/utils)

Prerequisites
- Java 11 or later
- Use the included Gradle Wrapper (`gradlew` / `gradlew.bat`)

Build & Run

Windows (PowerShell):

```powershell
.\gradlew.bat build
.\gradlew.bat bootRun
```

Linux / macOS:

```bash
./gradlew build
./gradlew bootRun
```

After startup the application runs on the port configured in the application configuration file: [src/main/resources/application.yml](src/main/resources/application.yml)

Run tests

```bash
./gradlew test
```

Windows:

```powershell
.\gradlew.bat test
```

Configuration
- Main configuration: [src/main/resources/application.yml](src/main/resources/application.yml)
- If you use Redis, check [src/main/java/com/johnny/singlegradlespringboot/redis/RedisConnection.java](src/main/java/com/johnny/singlegradlespringboot/redis/RedisConnection.java) and [src/main/java/com/johnny/singlegradlespringboot/redis/RedisTemplateConfig.java](src/main/java/com/johnny/singlegradlespringboot/redis/RedisTemplateConfig.java)

Project structure (short)
- Application: [src/main/java/com/johnny/singlegradlespringboot/SingleGradleApplication.java](src/main/java/com/johnny/singlegradlespringboot/SingleGradleApplication.java)
- Controller: [src/main/java/com/johnny/singlegradlespringboot/controller](src/main/java/com/johnny/singlegradlespringboot/controller)
- Entity / Pojo: [src/main/java/com/johnny/singlegradlespringboot/entity](src/main/java/com/johnny/singlegradlespringboot/entity) and [src/main/java/com/johnny/singlegradlespringboot/pojo](src/main/java/com/johnny/singlegradlespringboot/pojo)
- Repository: [src/main/java/com/johnny/singlegradlespringboot/repository](src/main/java/com/johnny/singlegradlespringboot/repository)
- Service: [src/main/java/com/johnny/singlegradlespringboot/service](src/main/java/com/johnny/singlegradlespringboot/service)
- Utils: [src/main/java/com/johnny/singlegradlespringboot/utils](src/main/java/com/johnny/singlegradlespringboot/utils)

Notes & tips
- Use the Gradle Wrapper included in the project to ensure a consistent Gradle version.
- Update [src/main/resources/application.yml](src/main/resources/application.yml) if you change the server port or active profile.
- The codebase includes sample utilities and algorithms (e.g., Snowflake ID, ConsistentHash) under the `utils` package for reference or reuse.

Next steps
- If you want, I can add more detailed usage examples, API examples, or translate this README into other formats.

