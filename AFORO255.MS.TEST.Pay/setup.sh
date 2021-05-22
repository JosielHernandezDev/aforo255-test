echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-pay
docker rm  app-pay
echo **************************************************************
docker build -t josielh12121296/AFORO255.MS.TEST.Pay .
docker push  josielh12121296/AFORO255.MS.TEST.Pay
echo **************************************************************
echo run image 
docker run -p 8006:8006 --name app-pay --network aforo255-test -d josielh12121296/AFORO255.MS.TEST.Pay
echo *************************************************************
echo End Process
echo *************************************************************