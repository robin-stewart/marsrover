package robinstewart.marsrover.service;

import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ImageService {
    private final Logger logger = LoggerFactory.getLogger(DatesService.class);

    public String saveImage(String date) {
        //TODO : check if file for date exists
        HttpGet httpGet = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=ALhgHrwCAVslfo4evBwQzjnWlmgbNSYJCgAwVCBw&earth_day=" + date);

        return null;
    }
}
