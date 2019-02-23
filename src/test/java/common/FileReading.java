package common;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileReading {

    @Test
    public void testReadFile() {
        InputStream inputStream = this.getClass().getResourceAsStream("/test-file");

        //try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        //    String line;
        //    while ((line = br.readLine()) != null) {
        //        System.out.println(line);
        //    }
        //} catch (Exception e) {
        //
        //}

        try {
            Path path = Paths.get(getClass().getResource("/test-file").toURI());
            String fileInline = Files.readAllLines(path).stream().collect(Collectors.joining()).trim();
            System.out.println(fileInline);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
