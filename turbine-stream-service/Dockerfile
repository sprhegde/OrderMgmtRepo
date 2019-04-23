FROM java:8-jre


ADD /home/travis/.m2/repository/com/ordermgmt/turbine-stream-service/1.0-SNAPSHOT/turbine-stream-service-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/turbine-stream-service.jar"]

EXPOSE 8989