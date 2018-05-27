package com.example.server.repositories;

import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Account;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Log4j2
public class DataRepositoryImpl implements DataRepository {

    @Value("${data.source.file}")
    private String dataSourceFile;

    @Override
    public List<Account> readFileContents() throws DataSourceNotAvailableException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = TypeReference.class.getResourceAsStream(dataSourceFile);
        try {
            log.info(String.format("Reading values from file '%s'.", dataSourceFile));
            return mapper.readValue(inputStream, new TypeReference<List<Account>>(){});
        } catch (IOException e){
            log.error("Unable to read data from source file.");
            throw new DataSourceNotAvailableException(e.getMessage());
        }
    }

}
