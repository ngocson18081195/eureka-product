package rio.unknown.common;

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

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileUtils {

    private static final Character SEPARATE = '/';
    @Value("${unknown.media.folder-in}")
    private String directory;
    @Value("${unknown.media.path}")
    private String pathUrl;

    public String saveImage(MultipartFile img, String category) {
        String imgName = System.currentTimeMillis() + "-" + img.getOriginalFilename();
        String imgPath = Strings.join(Arrays.asList("", category, imgName), FileUtils.SEPARATE);
        String imgLocation = this.directory + imgPath;
        OutputStream outputStream = null;
        Path path = Paths.get(imgLocation);
        try (InputStream inputStream = img.getInputStream()) {
            if (!path.toFile().exists()) {
                Files.createDirectories(path.getParent());
            }
            outputStream = Files.newOutputStream(path);
            IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
        return this.pathUrl + imgPath;
    }
}
