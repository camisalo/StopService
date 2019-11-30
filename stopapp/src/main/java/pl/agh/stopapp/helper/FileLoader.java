package pl.agh.stopapp.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

class FileLoader {

    static BufferedReader loadFile(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(classloader.getResourceAsStream(fileName))));
    }
}
