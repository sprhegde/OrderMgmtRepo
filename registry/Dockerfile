FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD https://github.com/sprhegde/OrderMgmtRepo/releases/download/v1.5/registry-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry-0.0.1-SNAPSHOT.jar"]

EXPOSE 8761