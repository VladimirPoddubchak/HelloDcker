FROM openjdk:11

RUN mkdir -p /hellodocker/

WORKDIR /hellodocker/

COPY . /hellodocker/

ENTRYPOINT ["java", "-classpath", "target/classes" , "com.poddubchak.education.docker.Hello"]