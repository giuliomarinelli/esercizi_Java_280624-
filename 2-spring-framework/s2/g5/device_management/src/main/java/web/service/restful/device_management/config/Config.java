package web.service.restful.device_management.config;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class Config {

    @Bean
    public Cloudinary cloudinary(
            @Value("${cloudinary.cloud_name}") String name,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret
    ) {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", name,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

}
