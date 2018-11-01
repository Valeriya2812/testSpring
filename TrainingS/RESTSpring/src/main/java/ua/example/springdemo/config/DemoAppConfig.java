package ua.example.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc//эта аннотация разрешает нашему проекту использовать MVC
@ComponentScan("ua.example.springdemo")
public class DemoAppConfig {

}
