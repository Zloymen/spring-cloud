
java -jar EurekeServer-1.0-SNAPSHOT.jar --port=8000 --hostname=my-eureka-server.com --zone=http://my-eureka-server.com:8000/eureka/


./my-eureka-server-fr.sh


    chmod +x my-eureka-server-fr.sh
    chmod +x my-eureka-server-us.sh
    chmod +x my-eureka-server-vn.sh

https://o7planning.org/ru/11701/spring-cloud


Run service **WireMock**

    docker run -it --rm --name wiremock \
        -p 6666:8080 \
        -v /work/other/loadbalance/mockData:/home/wiremock \
        rodolpheche/wiremock
    
    
/home/wiremock/testData1.jso    