package com.dhruv.productcatalog2026.Clients;

import com.dhruv.productcatalog2026.execptions.ProductNotExistException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Component 
public class FakestoreAPIClient {
    
    @Autowired 
    RestTemplate restTemplate;
    
    public <T> T requestForBody(
        HttpMethod httpMethod,
        String url,
        Object request,
        Class<T> responseType,
        String failureMessage,
        Object... uriVariables
    ) {
        ResponseEntity<T> response;
        try {
            response = restTemplate.exchange(
                url,
                httpMethod,
                new HttpEntity<>(request),
                responseType,
                uriVariables
            );
        } catch (HttpClientErrorException.NotFound exception) {
            throw new ProductNotExistException(failureMessage);
        }
        T body = response.getBody();
        if (!response.getStatusCode().is2xxSuccessful() || body == null) {
            throw new ProductNotExistException(failureMessage);
        }
        return body;
    }
    

}
