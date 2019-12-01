package pl.agh.stopapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.stopapp.entity.Next;
import pl.agh.stopapp.entity.Stop;
import pl.agh.stopapp.entity.StopEdge;
import pl.agh.stopapp.helper.Loader;
import pl.agh.stopapp.repository.StopEdgeRepository;
import pl.agh.stopapp.repository.StopRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StopService {

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private StopEdgeRepository stopEdgeRepository;

    @PostConstruct
    public void loadMaterials() throws IOException {
        Loader.loadStops(stopRepository);
        Loader.loadEdges(stopEdgeRepository);
    }

    public List<Stop> getStops() {
        List<Stop> stops = new ArrayList<>();
        this.stopRepository.findAll().forEach(stops::add);
        for (Stop stop : stops) {
            this.addNextStop(stop);
        }
        return stops;
    }

    public Stop getStopById(Integer id) {
        Stop stop = stopRepository.findStopById(id);
        if (stop != null) {
            this.addNextStop(stop);
        }
        return stop;
    }

    public Stop getStopByName(String name) {
        Stop stop = stopRepository.findStopByName(name);
        if (stop != null) {
            this.addNextStop(stop);
        }
        return stop;
    }

    private void addNextStop(Stop stop) {
        List<Next> nextList = new ArrayList<>();
        for (StopEdge stopEdge :
                stopEdgeRepository.findByStop1OrStop2(stop.getId(), stop.getId())) {
            Next next = new Next();
            if (stopEdge.getStop1() != stop.getId()) {
                next.setNextStopId(stopEdge.getStop1());
                next.setNextStopName(
                        stopRepository.findStopById(stopEdge.getStop1()).getName()
                );
            } else {
                next.setNextStopId(stopEdge.getStop2());
                next.setNextStopName(
                        stopRepository.findStopById(stopEdge.getStop2()).getName()
                );
            }
            next.setDuration(stopEdge.getDuration());
            nextList.add(next);
        }
        stop.setNextList(nextList);
    }
}