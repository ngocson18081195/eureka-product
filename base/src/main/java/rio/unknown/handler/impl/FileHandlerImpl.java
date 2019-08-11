package rio.unknown.handler.impl;

import com.dropbox.core.DbxException;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import rio.unknown.handler.FileHandler;
import rio.unknown.service.DropBoxService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by chien on 8/11/19.
 */
@Component
@Slf4j
public class FileHandlerImpl implements FileHandler {

    @Value("${unknown.media.path}")
    private String pathUrl;

    @Autowired
    private DropBoxService dropBoxService;

    @Override
    public String saveImage(MultipartFile img, String... categories) {
        String imgName = System.currentTimeMillis() + "_" + img.getOriginalFilename();
        String imgPath = FileHandler.SLASH
                + Strings.join(Arrays.asList(categories), FileHandler.SLASH)
                + FileHandler.SLASH + imgName;

        try (InputStream inputStream = img.getInputStream()) {
            this.dropBoxService.saveFile(imgPath, inputStream);
            return this.pathUrl + imgPath;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (DbxException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void loadFileToOutputStream(OutputStream outputStream, String pathFile) throws IOException, DbxException {
        this.dropBoxService.downloadFileToOutput(pathFile, outputStream);
    }
}
