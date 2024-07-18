package com.matricula.matricula.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ApplicationContext applicationContext;

    public <S, T> T map(S source, Class<T> targetClass, String... mapperBean) {
        ModelMapper modelMapper = getModelMapper(mapperBean);
        return modelMapper.map(source, targetClass);
    }

    public <S, T> List<T> map(List<S> source, Class<T> targetClass, String... mapperBean) {
        ModelMapper modelMapper = getModelMapper(mapperBean);
        return source
                .stream()
                .map(e -> modelMapper.map(e, targetClass))
                .toList();
    }

    private ModelMapper getModelMapper(String... mapperQualifier) {
        if (mapperQualifier.length == 0 || mapperQualifier[0] == null || mapperQualifier[0].isEmpty()) {
            return applicationContext.getBean("defaultMapper", ModelMapper.class);
        } else {
            return applicationContext.getBean(mapperQualifier[0], ModelMapper.class);
        }
    }
}
