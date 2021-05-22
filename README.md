# aforo255-test
![image](https://user-images.githubusercontent.com/73715766/119086107-9b010600-b9ca-11eb-8edb-c951d354d13a.png)

# DB Docker Images:
-docker run -p 3307:3306  --name microservicio-mysql8 --network aforo255-test -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=db_operation -d mysql:8​
-docker run -d -p 9411:9411 --name zipkin --network aforo255-test openzipkin/zipkin
-docker run  -d -p 6379:6379 --name redis --network aforo255-test redis:5-alpine
-docker run -p 5433:5432  --name microservicio-postgres12 --network aforo255-test -e POSTGRES_PASSWORD=123456 -e  POSTGRES_DB=db_invoice -d postgres:12-alpine
-docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=1a.2b.3c."   -p 1433:1433 --name sqlservice --network aforo255-test  -d mcr.microsoft.com/mssql/server:2019-CU3-ubuntu-18.04
-docker run -p 27018:27017 --network aforo255-test --name mongodb -d mongo​
