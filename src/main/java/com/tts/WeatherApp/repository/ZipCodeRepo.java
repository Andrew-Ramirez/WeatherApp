package com.tts.WeatherApp.repository;

import com.tts.WeatherApp.domain.ZipCode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZipCodeRepo extends CrudRepository<ZipCode, Long> {
    List<ZipCode> findByZipCode(String zipCode);
}
