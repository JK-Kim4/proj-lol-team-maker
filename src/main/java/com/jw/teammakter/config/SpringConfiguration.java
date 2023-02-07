package com.jw.teammakter.config;

import com.jw.teammakter.repository.JDBCMakerRepository;
import com.jw.teammakter.repository.JDBCPlayerRepository;
import com.jw.teammakter.repository.MakerRepository;
import com.jw.teammakter.repository.PlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {

    //JDBC 연동 이후 Bean 객체 수정
    private DataSource dataSource;

    public SpringConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MakerRepository makerRepository(){
//        return new MemoryMakerRepository();
        return new JDBCMakerRepository(dataSource);
    }

    @Bean
    public PlayerRepository playerRepository(){
        return new JDBCPlayerRepository(dataSource);
    }
}
