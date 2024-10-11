package com.huffowicz.spotter.controller;

import com.huffowicz.spotter.service.SerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpotterController {

    @Autowired
    private SerialService serialService;

    @GetMapping("/getFrequency")
    public String getFrequency() {
        return serialService.sendFrequencyCommand("COM6", "FA;");
    }

    @PostMapping("/post")
    public ResponseEntity<String> postFrequency(@RequestParam String frequency, @RequestParam String comment, @RequestParam String station, @RequestParam String county, @RequestParam String poster) {
        String url = "http://qsopartyhub.com/paqp-spots.php";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("station", station);
        map.add("frequency", frequency);
        map.add("county", county);
        map.add("comment", comment);
        map.add("poster", poster);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Failed to send data");
        }
    }
}
