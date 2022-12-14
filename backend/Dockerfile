FROM bellsoft/liberica-openjdk-alpine:17
LABEL image="tnas/alticci-api"
LABEL version="1.0"
LABEL description="API for Alticci Sequence"
EXPOSE 8083
WORKDIR /alticci
COPY target/alticci-0.0.1-SNAPSHOT.jar .
ENTRYPOINT java -jar ./alticci-0.0.1-SNAPSHOT.jar