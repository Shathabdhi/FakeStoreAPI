package com.example.FakeStrore.Client;

import com.example.FakeStrore.DTO.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
@Component
public class FakeStoreClient
{
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseURL;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductUrl = fakeStoreAPIBaseURL.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductUrl,FakeStoreProductResponseDTO[].class);
                return List.of(Objects.requireNonNull(productResponseList.getBody()));
    }

}