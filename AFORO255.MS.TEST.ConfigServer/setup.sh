echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-config
docker rm  app-config
echo **************************************************************
docker build -t josielh12121296/AFORO255.MS.TEST.ConfigServer .
docker push  josielh12121296/AFORO255.MS.TEST.ConfigServer
echo **************************************************************
echo run image 
docker run -p 8888:8888 --name app-config --network aforo255-test -d josielh12121296/AFORO255.MS.TEST.ConfigServer
echo *************************************************************
echo End Process
echo *************************************************************