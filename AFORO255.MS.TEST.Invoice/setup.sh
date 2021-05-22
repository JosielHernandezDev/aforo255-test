echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-invoices
docker rm  app-invoices
echo **************************************************************
docker build -t josielh12121296/AFORO255.MS.TEST.Invoice .
docker push  josielh12121296/AFORO255.MS.TEST.Invoice
echo **************************************************************
echo run image 
docker run -p 8007:8007 --name app-invoices --network aforo255-test -d josielh12121296/AFORO255.MS.TEST.Invoice
echo *************************************************************
echo End Process
echo *************************************************************