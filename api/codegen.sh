#!/bin/bash

set -e

rm -rf src/main/java/com/ctof/api
gradle -Pjson run
gradle run
#sed "s/Min(1.0)/Min(1)/g" ../api/src/main/java/com/example/api/PaginationParameters.java > /tmp/PaginationParameters.java
#mv /tmp/PaginationParameters.java ../api/src/main/java/com/example/api/PaginationParameters.java
