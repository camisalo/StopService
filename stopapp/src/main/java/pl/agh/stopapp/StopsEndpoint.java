package pl.agh.stopapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.stopapp.entity.Stop;
import pl.agh.stopapp.helper.JsonHelper;
import pl.agh.stopapp.services.StopService;

import java.util.List;

@RestController
public class StopsEndpoint {

    @Autowired
    private StopService stopService;

    @RequestMapping(value = "/api/stops", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStops() {

        List<Stop> stopList = stopService.getStops();
        if (stopList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(JsonHelper.stopToJson(stopList));
    }

    @RequestMapping(value = "/api/stop/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStopById(@PathVariable Integer id) {

        Stop stop = stopService.getStopById(id);
        if (stop == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(JsonHelper.stopToJson(stop));
    }

    @RequestMapping(value = "/api/stop/name/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStopById(@PathVariable String name) {

        Stop stop = stopService.getStopByName(name);
        if (stop == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(JsonHelper.stopToJson(stop));
    }
}