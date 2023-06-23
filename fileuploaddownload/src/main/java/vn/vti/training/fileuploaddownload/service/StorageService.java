package vn.vti.training.fileuploaddownload.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.vti.training.fileuploaddownload.entity.FileData;
import vn.vti.training.fileuploaddownload.repository.FileRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class StorageService {
    private final FileRepository repo;
    @Value("${upload.path}")
    private String path;


    public StorageService(FileRepository repo) {
        this.repo = repo;
    }

    public String uploadToFile(MultipartFile file) throws IOException {
        String filePath = path+file.getOriginalFilename();
        FileData data= FileData.builder()
                .id(UUID.randomUUID().toString())
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .build();
//        file.transferTo(new File(filePath));
        var is = file.getInputStream();
        Files.copy(is, Paths.get(path + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        if(data!=null){

            repo.saveFile(data);
            return "Upload image successfully: "+ file.getOriginalFilename()+ " with:" + data.getId();
        }
        return null;
    }

    public byte[] downloadFile(String fileName) throws IOException {
        FileData db =repo.findByName(fileName);
        String filePath = db.getFilePath();
        byte[] image = Files.readAllBytes(new File(filePath).toPath());
        return image;
    }

    public byte[] renderFile(String id) throws IOException {
        FileData db =repo.findById(id);
        String filePath = db.getFilePath();
        byte[] image = Files.readAllBytes(new File(filePath).toPath());
        return image;
    }

}
