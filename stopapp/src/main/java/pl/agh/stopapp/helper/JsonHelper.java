package pl.agh.stopapp.helper;

import com.google.gson.Gson;
import pl.agh.stopapp.entity.Stop;

import java.util.List;

public class JsonHelper {

    private static Gson gson = new Gson();

    public static String stopToJson(Stop stop) {
        return gson.toJson(stop);
    }

    public static String stopToJson(List<Stop> stopList) {
        return gson.toJson(stopList);
    }
}
