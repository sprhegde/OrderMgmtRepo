FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD /home/travis/.m2/repository/com/ordermanagement/order-service/1.0-SNAPSHOT/order-service-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/order-service-1.0-SNAPSHOT.jar"]

EXPOSE 6000