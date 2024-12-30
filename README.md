# BitLyService
Implementing a URL Shortener with basic analytics.
The Service will accept a url in it's long form and convert it into a shorter encoded format using md5 encoding. For now storing in JPARepository. In further increments, will implement Redis cache.
## Requirements

1. Java - 17

2. Gradle -8.2

## Steps to setup

**1. Clone the application**

```bash
git clone https://github.com/RoyArunim/BitLyService.git

```

**2. Build and run the app using gradle

```bash
cd BitlyService
gradlew clean build
```
