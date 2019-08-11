package rio.unknown.handler;

import com.dropbox.core.DbxException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by chien on 8/11/19.
 */
public interface FileHandler {

    Character SLASH = '/';

    String saveImage(MultipartFile img, String... categories);

    void loadFileToOutputStream(OutputStream outputStream, String pathImg) throws IOException, DbxException;

}
