# Topic Test

## Prerequisites

Install the following tools before you continue:

* Java 1.8
* Gradle 2.8

## Run

Start web server
```
gradle run
```

Insert data
```
curl -i -H "Content-type: application/json" localhost:8090/topics -d '{"title":"a", "body":"aaa", "userId":"101", "category":"frontend", "reward":10}'
```
