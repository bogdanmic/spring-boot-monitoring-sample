FROM openjdk:11-jdk-slim-stretch

COPY target/*.jar /apps/spring_app/app.jar

WORKDIR /apps/spring_app

# To shut down the spring boot app gracefully: http://veithen.github.io/2014/11/16/sigterm-propagation.html
CMD exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar