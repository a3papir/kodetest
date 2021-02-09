FROM openjdk:8
ADD target/kodetest.jar kodetest.jar
EXPOSE 9000
ENTRYPOINT [ "java", "-jar","kodetest.jar"]