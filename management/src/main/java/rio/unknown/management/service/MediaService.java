package rio.unknown.management.service;

import com.dropbox.core.DbxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chien on 8/11/19.
 */
public interface MediaService {

    void loadFile(HttpServletResponse response, HttpServletRequest request) throws IOException, DbxException;
}
