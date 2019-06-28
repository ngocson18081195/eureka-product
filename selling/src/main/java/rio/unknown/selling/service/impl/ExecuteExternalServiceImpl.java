package rio.unknown.selling.service.impl;

import rio.unknown.common.Response;
import rio.unknown.selling.service.ExecuteExternalService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExecuteExternalServiceImpl implements ExecuteExternalService {

    /**
     * Read take note `1` in file `README.md` root.
     */

    // fixme --- Temporary implement
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public <T> List<T> getCollectionOrEmpty(String host, String url, Class<T> tClass) {
        String urlRequest = host.concat(url);
        // fixme --- be able occurred exception
        Response response = restTemplate.getForObject(urlRequest, Response.class);
        if (Objects.nonNull(response)) {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, tClass);
            return objectMapper.convertValue(response.getData(), collectionType);
        }

        return Collections.emptyList();
    }

    @Override
    public <T> T getOneOrNull(String host, String url, Class<T> tClass) {
        String urlRequest = host.concat(url);
        // fixme --- be able occurred exception
        Response response = restTemplate.getForObject(urlRequest, Response.class);
        if (Objects.nonNull(response)) {
            return objectMapper.convertValue(response.getData(), tClass);
        }
        return null;
    }
}
