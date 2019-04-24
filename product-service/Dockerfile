FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD ./target/product-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/product-service.jar"]

EXPOSE 7000