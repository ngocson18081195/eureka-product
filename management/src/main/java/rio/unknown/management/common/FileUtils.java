package rio.unknown.management.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.logging.log4j.util.Strings;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileUtils {

    @Value("${unknown.media.folder-in}")
    private String directory;

    @Value("${unknown.media.path}")
    private String pathUrl;

    private static final Character SEPERATE = '/';

    public String saveImage(MultipartFile img, String category) {
        String imgName = System.currentTimeMillis() + "-" + img.getOriginalFilename();
        String imgPath = Strings.join(Arrays.asList("", category, imgName), FileUtils.SEPERATE);
        String imgLocation = this.directory + imgPath;
        try {
            Path path = Paths.get(imgLocation);
            if (Files.notExists(path)) {
                Files.createDirectories(path.getParent());
            }
            @Cleanup
            InputStream inputStream = img.getInputStream();
            @Cleanup
            OutputStream outputStream = Files.newOutputStream(path);
            IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return this.pathUrl + imgPath;
    }
}
