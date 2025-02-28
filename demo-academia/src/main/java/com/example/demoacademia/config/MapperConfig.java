package com.example.demoacademia.config;

import com.example.demoacademia.dto.AlumnDTO;
import com.example.demoacademia.model.Alumn;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

    @Bean("alumnMapper")
    public ModelMapper alumnMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(Alumn.class, AlumnDTO.class)
                .addMapping(e->e.getFirsname(),(dest, v)->dest.setFirstnameAlumn((String) v));

        mapper.createTypeMap(AlumnDTO.class, Alumn.class)
                .addMapping(AlumnDTO::getFirstnameAlumn,(dest, v)->dest.setFirsname((String) v));

        return mapper;
    }

}
