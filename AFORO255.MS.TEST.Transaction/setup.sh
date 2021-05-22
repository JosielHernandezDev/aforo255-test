echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-transaction
docker rm  app-transaction
echo **************************************************************
docker build -t josielh12121296/AFORO255.MS.TEST.Transaction .
docker push  josielh12121296/AFORO255.MS.TEST.Transaction
echo **************************************************************
echo run image 
docker run -p 8008:8008 --name app-transaction --network aforo255-test -d josielh12121296/AFORO255.MS.TEST.Transaction
echo *************************************************************
echo End Process
echo *************************************************************