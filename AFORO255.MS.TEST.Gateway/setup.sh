echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-gateway
docker rm  app-gateway
echo **************************************************************
docker build -t josielh12121296/AFORO255.MS.TEST.Gateway .
docker push  josielh12121296/AFORO255.MS.TEST.Gateway
echo **************************************************************
echo run image 
docker run -p 8090:8090 --name app-gateway --network aforo255-test -d josielh12121296/AFORO255.MS.TEST.Gateway
echo *************************************************************
echo End Process
echo *************************************************************