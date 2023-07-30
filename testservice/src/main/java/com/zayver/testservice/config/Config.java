package com.zayver.testservice.config;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Autowired
    private EurekaClient eurekaClient;

    @Bean
    public ApplicationRunner eurekaMetadataRunner() {
        return args -> {
            ApplicationInfoManager applicationInfoManager = eurekaClient.getApplicationInfoManager();
            InstanceInfo instanceInfo = applicationInfoManager.getInfo();

            instanceInfo.getMetadata().put("MICROSERVICE-TYPE", "INFRASTRUCTURE");
            applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
        };
    }

}
