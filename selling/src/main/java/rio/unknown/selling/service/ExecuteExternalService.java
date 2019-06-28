package rio.unknown.selling.service;

import java.util.List;

public interface ExecuteExternalService {

    <T> List<T> getCollectionOrEmpty(String host, String url, Class<T> tClass);
}
