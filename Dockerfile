FROM gcr.io/distroless/java:11
COPY app/target/*.jar app.jar
CMD ["app.jar"]
