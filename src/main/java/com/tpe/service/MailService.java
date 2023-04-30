package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component("mailService") // when ComponentScanner scans POJO classes, it creates one instance from this class
//default bean name for this class is "mailService"
//@Scope(value = "singleton") //by default the value is singleton which means only one instance will be created
//whenever we call the object it will return us the same object
@Scope(value = "prototype") //creates new obj whenever we request the obj from the class
public class MailService implements MessageService{

    @Autowired
    private Random random;

     /*
     "@PostConstruct" is a Java annotation used to specify a method that needs to be executed after
     an object is constructed and all of its dependencies have been injected
     */

    @PostConstruct
    public void init(){
        System.out.println("Mail service object is created...");
    }

    /*
    "@PreDestroy" is used to annotate a method that needs to be executed just before the bean is destroyed by the container.
     This method is typically used to release any resources held by the bean before it is destroyed.
     */

    @PreDestroy
    public void Destroy(){
        System.out.println("Mail service object is destroyed...");
    }

    //there are 3 ways of Dependency Injection
    //1.Field injection
//    @Autowired // when spring creates instance from MailService, it will inject Repository
//    @Qualifier("fileRepository")
//    private Repository repository;//null

    //2.setter injection
//    private Repository repository;
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }

    //3.constructor injection
    //this way is suggested because it is more secure, when you write task it will be easy
    private Repository repository;
    @Autowired

    public MailService( @Qualifier("fileRepository")Repository repository) {
        this.repository = repository;
    }


    @Override
    public void sendMessage(Message message) {
        System.out.println("I am Mail service. I am sending this message: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        repository.save(message);
    }
    public void createRandom(){
        //Random random = new Random();

        System.out.println(random.nextInt(100));
    }



}
