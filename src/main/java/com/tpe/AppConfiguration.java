package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //this will be my configuration class
@ComponentScan("com.tpe") //by default, it will scan all the parallel packages
public class AppConfiguration {
}
