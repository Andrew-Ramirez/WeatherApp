package com.tts.WeatherApp;


import com.tts.WeatherApp.domain.ZipCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.tts.WeatherApp.repository.ZipCodeRepo;

@Service
public class WeatherService {
    @Value("${api_key}")
    private String apiKey;
    @Autowired
    private ZipCodeRepo repo;

    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" +
                zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        try {
            Response myResp = restTemplate.getForObject(url, Response.class);
            ZipCode zip = new ZipCode(zipCode,myResp.getName());
            repo.save(zip);
            return myResp;
        }
        catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }
    }
}
