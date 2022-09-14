package br.com.bb.t99.services;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@ApplicationScoped
@Traced
public class UsuarioService {


    public static String hello(){
        return "Hello Juliano!";
    }
    
    public static String helloComNome(String nome){
        return "Hello "+nome+"!";
    }

    public static String getHoraName(String name){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss", new Locale("pt", "BR"));  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println("hora "+dtf.format(now)); 
        //não esqueça
        return "Hello "+ name+"! Agora são "+dtf.format(now)+" não esqueca";
    }
}
