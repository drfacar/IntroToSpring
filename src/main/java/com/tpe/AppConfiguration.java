package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration //this is our configuration class
@ComponentScan("com.tpe") //to be able to scan my POJO classes and create one instance from each
//by default it will scan al packages which are inside com.tpe
//and put them inside spring container
@PropertySource("classpath:application.properties")//annotation to specify the location file that
// contains key-value pairs to be used in your application
public class AppConfiguration {

    @Autowired
    private Environment environment; //to read application.properties file we use Environment
    // Interface from Spring Framework
    // The Environment

    @Bean //create bean from Random class and put inside a container
    //Bean is used to create bean for existing classes
    public Random randomInteger(){
        return new Random();
    }
    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.put("email",environment.getProperty("app.email"));
        properties.put("phone",environment.getProperty("app.phone"));
        return properties;

    }
}