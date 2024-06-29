package web.service.restful.device_management.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    private String extractPublicId(String imageUrl) {
        // Extract public_id from Cloudinary URL
        String[] parts = imageUrl.split("/");
        String lastPart = parts[parts.length - 1];
        return lastPart.substring(0, lastPart.lastIndexOf("."));
    }

    public void deleteImageByUrl(String imageUrl) throws IOException {
        // Extract public_id from imageUrl
        String publicId = extractPublicId(imageUrl);

        // Delete image from Cloudinary
        Map result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }

}
