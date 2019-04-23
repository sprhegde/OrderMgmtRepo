FROM java:8-jre
MAINTAINER Shivaprasad Hegde <sprhegde@gmail.com>

ADD /home/travis/.m2/repository/com/ordermanagement/monitoring/0.0.1-SNAPSHOT/monitoring-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/monitoring-0.0.1-SNAPSHOT.jar"]

EXPOSE 8989 8080