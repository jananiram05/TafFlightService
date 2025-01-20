#FROM openjdk:17
FROM public.ecr.aws/docker/library/openjdk:17

COPY ./build/libs/tafflightservice.jar tafflightservice.jar
EXPOSE 8083
CMD ["java","-jar","tafflightservice.jar"]