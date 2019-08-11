package rio.unknown.management.service.impl;

import com.dropbox.core.DbxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rio.unknown.handler.FileHandler;
import rio.unknown.management.service.MediaService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chien on 8/11/19.
 */
@Service
public class MediaServiceImpl implements MediaService {

    @Value("${unknown.media.folder}")
    private String media;

    @Autowired
    private FileHandler fileHandler;

    @Override
    public void loadFile(HttpServletResponse response, HttpServletRequest request) throws IOException, DbxException {
        String requestURI = request.getRequestURI();
        final String pathFile = requestURI.replaceFirst(this.media, "");
        final ServletOutputStream outputStream = response.getOutputStream();
        this.fileHandler.loadFileToOutputStream(outputStream, pathFile);
    }
}
