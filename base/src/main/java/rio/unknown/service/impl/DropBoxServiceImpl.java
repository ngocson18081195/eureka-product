package rio.unknown.service.impl;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.unknown.service.DropBoxService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by chien on 8/8/19.
 */
@Service
public class DropBoxServiceImpl implements DropBoxService {

    @Autowired
    private DbxClientV2 dbxClientV2;

    @Override
    public FileMetadata saveFile(String pathFile, InputStream inputStream) throws IOException, DbxException {
        return this.dbxClientV2.files().uploadBuilder(pathFile)
            .uploadAndFinish(inputStream);
    }

    @Override
    public InputStream getFile(String pathFile) throws DbxException {
        return this.dbxClientV2.files().downloadBuilder(pathFile)
            .start().getInputStream();
    }

    @Override
    public void downloadFileToOutput(String pathFile, OutputStream outputStream) throws IOException, DbxException {
        this.dbxClientV2.files().downloadBuilder(pathFile)
            .download(outputStream);
    }
}
