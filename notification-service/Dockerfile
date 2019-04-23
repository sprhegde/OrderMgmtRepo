FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD /home/travis/.m2/repository/com/ordermanagement/notification-service/1.0.0-SNAPSHOT/notification-service-1.0.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/notification-service-1.0.0-SNAPSHOT.jar"]

EXPOSE 8000