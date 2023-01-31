package com.jw.teammakter.config;

import com.jw.teammakter.repository.MakerRepository;
import com.jw.teammakter.repository.MemoryMakerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    /*
    //JDBC 연동 이후 Bean 객체 수정
    private DataSource dataSource;

    public SpringConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }*/

    @Bean
    public MakerRepository makerRepository(){
        return new MemoryMakerRepository();

    }
}
