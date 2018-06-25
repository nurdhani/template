FROM azul/zulu-openjdk-debian:8u121
ENV TZ="/usr/share/zoneinfo/Asia/Manila"
VOLUME /tmp
ARG PROJECT_NAME
ADD ${PROJECT_NAME}.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT java -Xmx512m -jar -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$SPRING_PROFILE_ACTIVE /app.jar

