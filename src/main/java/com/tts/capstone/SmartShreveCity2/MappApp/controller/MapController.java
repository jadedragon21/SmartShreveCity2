package com.tts.capstone.SmartShreveCity2.MappApp.controller;



import com.tts.capstone.SmartShreveCity2.MappApp.model.Location;
import com.tts.capstone.SmartShreveCity2.MappApp.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MapController {

    private MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping(value="/weather")
    public String getDefaultMap(Model model) {
//        Location location = new Location();
//        location.setCity("Hartford");
//        location.setState("Connecticut");
//        mapService.addCoordinates(location);
//        System.out.println(location);
//        log.info("This is my location: {}", location);
        model.addAttribute(new Location());
        return "mappyweather";
    }

    @PostMapping(value="/weather")
    public String getMapForLocation(Location location, Model model) {
        mapService.addCoordinates(location);
        model.addAttribute(location);
        System.out.println(location);
        return "mappyweather";
    }

    // TODO: new feature in the future put this in StoreController with a post mapping
    // we use a getmapping to access the html template via a get HTTP method
    //@GetMapping("/store")
    //public String getStore() {
    // we return a string that is a reference to a template
    //return "store";
    //}



}
