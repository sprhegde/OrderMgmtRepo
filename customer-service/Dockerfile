FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD /home/travis/.m2/repository/com/ordermanagement/customer-service/1.0-SNAPSHOT/customer-service-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/customer-service-1.0-SNAPSHOT.jar"]

EXPOSE 6000