package com.mvc.service.service;

import com.mvc.service.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private RestTemplate restTemplate = new RestTemplate();

    public Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public ResponseEntity<String> getForEntity() {
        return restTemplate.getForEntity("http://localhost:8080/product", String.class);
    }

    public void postForObject(ProductDTO productDTO) {
        restTemplate.postForObject("http://localhost:8080/product/create", new HttpEntity<>(productDTO), ProductDTO.class);
    }

}
