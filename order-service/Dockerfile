FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD ./target/order-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/order-service.jar"]

EXPOSE 6000