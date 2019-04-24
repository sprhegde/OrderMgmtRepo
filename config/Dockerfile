FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD /home/travis/build/[secure]/OrderMgmtRepo/config/target/config-1.0.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-1.0.0-SNAPSHOT.jar"]

EXPOSE 8888