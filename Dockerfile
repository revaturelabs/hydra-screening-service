FROM openjdk:8-jdk-alpine
ADD . /SkillsService
WORKDIR /SkillsService
CMD ["java", "-jar", "target/SkillsService-1.jar"]