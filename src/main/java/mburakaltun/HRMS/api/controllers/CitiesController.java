package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.CityService;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add(@RequestParam String cityName) {
        return cityService.add(cityName);
    }
}
