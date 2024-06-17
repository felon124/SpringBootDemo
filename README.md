# Getting Started

### Local Test
```shell
brew install mvnvm // 安裝打包套件
mvn clean install  // 打包spring boot專案，產出deploy用的jar檔
mv ./target/SpringBootDemo-0.0.1-SNAPSHOT.jar ./application.jar
docker build -t springio/gs-spring-boot-docker --no-cache  .
docker run -p 8080:8080 springio/gs-spring-boot-docker
```
### Upload to GCP
要先產生好Artifact Registry Repo(例如asia-east1-docker.pkg.dev/lab-423307/demo)

否則上傳image會失敗

```shell
mvn clean install
mv ./target/SpringBootDemo-0.0.1-SNAPSHOT.jar ./application.jar
gcloud init
gcloud auth login
gcloud builds submit -t "asia-east1-docker.pkg.dev/lab-423307/demo/SpringBootDemo" ./
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

