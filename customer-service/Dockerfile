FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD https://github.com/sprhegde/OrderMgmtRepo/releases/download/v0.8/customer-service-1.0.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/customer-service-1.0.0-SNAPSHOT.jar"]

EXPOSE 6000