package hello;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class Utilities {

    static void readFile(String filename) {
        String normalizedFilename = FilenameUtils.normalize(filename);
        LineIterator it = null;
        try {
            File file = new ClassPathResource(normalizedFilename).getFile();
            it = FileUtils.lineIterator(file, "UTF-8");

            while (it.hasNext()) {
                String line = it.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            LineIterator.closeQuietly(it);
        }

    }


}
