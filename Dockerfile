# FROM openjdk:8-jdk
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
# CMD gunicorn --bind 0.0.0.0:$PORT wsgi

# FROM openjdk:8-jdk-alpine
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

# CMD gunicorn --bind 0.0.0.0:$PORT wsgi
# FROM openjdk:17-jdk-alpine
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
# CMD gunicorn --bind 0.0.0.0:$PORT wsgi

# FROM openjdk:11
# COPY . /usr/src/bankuser
# WORKDIR /usr/src/bankuser
# RUN javac Main.java
# CMD ["java", "Main"]

# FROM openjdk:11
# # FROM openjdk:17-jdk-alpine
# VOLUME /tmp
# ARG JAR_FILE
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
# FROM openjdk:8-jdk
# VOLUME /tmp
# ARG JAR_FILE
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]