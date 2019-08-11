package rio.unknown.management.controller;

import com.dropbox.core.DbxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rio.unknown.management.service.MediaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chien on 8/11/19.
 */
@RestController
@RequestMapping("${unknown.media.uri}")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping
    public void getFile(HttpServletResponse response,
                        HttpServletRequest request) throws IOException, DbxException {
        this.mediaService.loadFile(response, request);
    }
}
