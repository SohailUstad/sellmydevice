package in.sellmydevice.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import in.sellmydevice.dto.MobileRequest;
import in.sellmydevice.entity.Mobile;
import in.sellmydevice.repository.MobileRepository;

@RestController
@RequestMapping("/mobiles")
@CrossOrigin(origins = "*")
public class MobileController {

    @Autowired
    private MobileRepository mobileRepository;

    @Value("${image.upload.directory}")
    private String imageUploadDirectory;

    @PostMapping
    public boolean addNewMobile(@RequestBody MobileRequest request) {
        try {
            Mobile mobile = request.getMobile();
            String imageData = request.getImage(); // This should be a base64-encoded image

            // Decode the base64 image and save it to the appropriate location
            byte[] imageBytes = Base64.getDecoder().decode(imageData);

            // Generate a unique file name using UUID and timestamp
            String uniqueFileName = generateUniqueFileName("image.png");

            // Create the file in the upload directory
            File file = new File(imageUploadDirectory + uniqueFileName);

            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(imageBytes);
            }

            mobile.setImage(imageUploadDirectory + uniqueFileName);

            // Save the mobile entity with the image path
            return mobileRepository.save(mobile) != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @GetMapping
    public List<Mobile> getAllMobile() {
        return mobileRepository.findAll();
    }

    private String generateUniqueFileName(String originalFileName) {
        String uniqueID = UUID.randomUUID().toString();
        long timestamp = Instant.now().toEpochMilli();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return uniqueID + timestamp + fileExtension;
    }
}
