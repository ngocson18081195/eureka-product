package rio.unknown.config;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chien on 8/8/19.
 */
@Configuration
public class CommonBean {

    @Value("${dropbox.accessToken}")
    private String accessToken;

    @Bean
    public DbxClientV2 initialBeanDropBox() {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("Unknown").build();
        return new DbxClientV2(config, this.accessToken);
    }
}
