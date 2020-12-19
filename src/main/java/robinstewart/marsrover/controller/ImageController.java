package robinstewart.marsrover.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import robinstewart.marsrover.service.ImageService;

import javax.inject.Inject;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class ImageController {
    @Inject
    private ImageService imageService;

    @RequestMapping(value = "image", method = RequestMethod.GET)
    public ResponseEntity saveImage(String date) {
        return imageService.saveImage(date) != null ? new ResponseEntity(HttpStatus.ACCEPTED) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
