echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-security
docker rm  app-security
echo **************************************************************
docker build -t josielh12121296/AFORO255.MS.TEST.Security .
docker push  josielh12121296/AFORO255.MS.TEST.Security
echo **************************************************************
echo run image 
docker run -p 8010:8010 --name app-security --network aforo255-test -d josielh12121296/AFORO255.MS.TEST.Security
echo *************************************************************
echo End Process
echo *************************************************************