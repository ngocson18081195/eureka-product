package rio.unknown.service;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by chien on 8/8/19.
 */
public interface DropBoxService {

    FileMetadata saveFile(String pathFile, InputStream inputStream) throws IOException, DbxException;
    InputStream getFile(String pathFile) throws DbxException;
    void downloadFileToOutput(String pathFile, OutputStream outputStream) throws IOException, DbxException;
}
