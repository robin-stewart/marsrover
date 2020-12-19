package robinstewart.marsrover.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import robinstewart.marsrover.service.DatesService;

import javax.inject.Inject;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class DatesController {
    @Inject
    private DatesService datesService;

    @RequestMapping(value = "dates", method = RequestMethod.GET)
    public List<String> getDates() {
        return datesService.getDates();
    }
}
