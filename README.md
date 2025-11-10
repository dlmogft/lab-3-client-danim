# lab-3-client-danim

This is a Spring Cloud Config **client project** that uses the configuration files from the **spring-cloud-server-config-danim** loaded by the Spring Cloud Config **server project** **lab-3-server-danim**.

# Starting the application

The steps to used it are:
- Start the **lab-3-server-danim** repo and check it's started correctly in http://localhost:8001
- Start the Java class annotated by @SpringBootApplication and check that the sentence is correctly shown in http://localhost:8002/lucky-word
The project can also be started to connect to Kafka in order to refresh the configuration via publishing a message in a Kafka topic. The steps to do this are:
- Start a local installation of Kafka in localhost:9092
- Start the **lab-3-server-danim** project with Kafka profile, mvn spring-boot:run -Dspring.profiles.active=kafka
- Change the configuration value for wordConfig.luckyWord in lucky-word-client.yml from repository spring-cloud-server-config-danim
- Execute the endpoint localhost:8001/actuator/busrefresh from the **lab-3-server-danim** project
- Start this project with Kafka profile, **mvn spring-boot:run -Dspring.profiles.active=kafka** and open http://localhost:8002/lucky-word. The displayed word should be loaded

# Dependencies

Spring Web, Config Server

# Tips

- The project starting class is annotated with **@SpringBootApplication**
- The **application.yml** config file specifies the URI of the Config Server repo **lab-3-server-danim** and also the profile to read the correct **application-<profile>.yml** file from the **spring-cloud-server-config-danim** Git repository. It also has a defaualt value for the lucky-word key
- The **LuckyWordController** has a variable that points to the lucky-word key in the **application-<profile>.yml** file from the **spring-cloud-server-config-danim** Git repository
