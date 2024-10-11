FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install
#RUN mvn clean install

FROM eclipse-temurin:17-jre-jammy
MAINTAINER sapient
WORKDIR /
EXPOSE 8080
COPY --from=builder /target/*.jar /*.jar
ENTRYPOINT ["java", "-jar", "/*.jar"]