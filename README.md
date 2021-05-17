# Read Me First

* Article Monitoring Service - by Pocholo Calapre
* The implementation in based on spring-boot framework with H2 in memory database 

### Prerequisites 
The following prerequisites and should already be installed in the system

* JDK 1.8 or later
* Maven 3.2+
* Docker latest version

### How to build and run
The following guides illustrate how to use some features concretely:

* Build/Create executable jar file and Run
$> export MVNW_VERBOSE=true
$> ./mvnw package
$> java -jar target/article-monitoring-0.0.1-SNAPSHOT.jar

* H2 database can be accessed using this url
http://localhost:8080/h2-ui
Driver Class: org.h2.Driver
JDBC Url: jdbc:h2:mem:testdb (for in-memory database)
JDBC Url: jdbc:h2:file:~/<path to db file> (for file based persistency database)
Username: sa
Password: 

* (Optional) The service can be run inside Docker container
$> docker build -t article-monitoring .
$> docker run -it -p8080:8080 article-monitoring:latest

### Example REST api requests
* GET : Get all news articles
http://localhost:8080/newsArticleMonitoring/listAllNewsArticle
* POST : Add news article
http://localhost:8080/newsArticleMonitoring/NewsArticle
Sample Body raw json
{
	"title": "Article 1",
	"text": "Text of Article 1"
}
* GET : Get Article by id
http://localhost:8080/newsArticleMonitoring/NewsArticle/1
* DELETE : Delete an Article by id
http://localhost:8080/newsArticleMonitoring/NewsArticle/1

