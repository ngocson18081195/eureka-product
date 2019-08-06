package rio.unknown.management.test;

import com.dropbox.core.*;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.*;
import java.util.Locale;

/**
 * Created by chien on 8/4/19.
 */
public class DropboxTest {

    public static void main(String[] args) throws DbxException, IOException {
//        final String APP_KEY = "ui9sz6kmoexvyoh";
//        final String APP_SECRET = "tmt3gv8ymcid50e";
//
//        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig(
            "JavaTutorial/1.0", Locale.getDefault().toString());
//        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
//        String authorizeUrl = webAuth.start();
//        System.out.println("authorizeUrl = " + authorizeUrl);
//        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
//        DbxAuthFinish authFinish = webAuth.finish(code);
        String accessToken = "jlgOsstEoZAAAAAAAAAAK43XMxBoGDkRe0-Y3EANnu4cF336D88y4AvLzKSf3P-B";
        System.out.println("accessToken = " + accessToken);
        DbxClientV2 client = new DbxClientV2(config, accessToken);
        System.out.println("Linked account: " + client.users().getCurrentAccount());
        try (InputStream in = new FileInputStream("./test.txt")) {
            FileMetadata metadata = client.files().uploadBuilder("/test.txt")
                .uploadAndFinish(in);
            System.out.println("metadata = " + metadata);
        }
    }
}
