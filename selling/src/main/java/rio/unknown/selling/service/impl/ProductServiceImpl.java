package rio.unknown.selling.service.impl;

import rio.unknown.info.ProductInfo;
import rio.unknown.selling.service.ExecuteExternalService;
import rio.unknown.selling.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ExecuteExternalService executeExternalService;

    @Override
    public List<ProductInfo> getAll() {
        // fixme --- temporary
        String host = "http://localhost:8081";
        String url = "/products";
        return this.executeExternalService.getCollectionOrEmpty(host, url, ProductInfo.class);
    }
}
