package Classes;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class JsonUtils {

    public static String readJsonFileAsString(String filePath) {
        try {
            Path path = Paths.get(filePath);
            byte[] jsonData = Files.readAllBytes(path);
            return new String(jsonData);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de error (puedes personalizar según tus necesidades)
            return null;
        }
    }

}
