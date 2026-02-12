package com.example.EmployeeTask;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = "com.qvantel.common")
public class ServiceTemplateConfig {

}
