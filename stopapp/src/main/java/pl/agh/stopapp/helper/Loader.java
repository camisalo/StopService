package pl.agh.stopapp.helper;

import org.springframework.stereotype.Service;

import pl.agh.stopapp.entity.Stop;
import pl.agh.stopapp.entity.StopEdge;
import pl.agh.stopapp.repository.StopEdgeRepository;
import pl.agh.stopapp.repository.StopRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class Loader {

    public static void loadStops(StopRepository stopRepository) throws IOException {
        try(BufferedReader reader = FileLoader.loadFile("stops.csv")) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(";");
                Stop stop = new Stop();
                stop.setId(Integer.parseInt(data[0]));
                stop.setName(data[1]);
                stopRepository.save(stop);
            }
        }
    }

    public static void loadEdges(StopEdgeRepository stopEdgeRepository) throws IOException {
        try(BufferedReader reader = FileLoader.loadFile("edges.csv")) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(";");
                StopEdge stopEdge = new StopEdge();
                stopEdge.setStop1(Integer.parseInt(data[0]));
                stopEdge.setStop2(Integer.parseInt(data[1]));
                stopEdge.setDuration(Integer.parseInt(data[2]));
                stopEdgeRepository.save(stopEdge);
            }
        }
    }

}
