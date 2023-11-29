package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}

@RestController
class MyController {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @PostMapping("/create")
  public String create() {
    // ランダムなデータ生成
    Map<String, Object> requestData = generateRandomData();

    // データをJSONに変換
    String jsonRequestData = convertToJson(requestData);

    // データを保存または処理するロジックをここに追加

    return "Data created successfully!\n" + jsonRequestData;
  }

  private Map<String, Object> generateRandomData() {
    Map<String, Object> data = new HashMap<>();
    Random random = new Random();

    data.put("name", getRandomString(5));
    data.put("age", random.nextInt(100));
    data.put("city", getRandomString(8));

    return data;
  }

  private String getRandomString(int length) {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder randomString = new StringBuilder(length);

    for (int i = 0; i < length; i++) {
      randomString.append(characters.charAt(new Random().nextInt(characters.length())));
    }

    return randomString.toString();
  }

  private String convertToJson(Object data) {
    try {
      return objectMapper.writeValueAsString(data);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return "";
    }
  }
}
