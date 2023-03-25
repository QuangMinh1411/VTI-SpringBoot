package vn.vti.training.fileuploaddownload.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.vti.training.fileuploaddownload.service.StorageService;

@RestController
@RequestMapping("/image")
public class FileController {
    private final StorageService service;

    public FileController(StorageService service) {
        this.service = service;
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image") MultipartFile image) throws Exception {
        String uploadImage = service.uploadToFile(image);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable("fileName")String name) throws Exception {
        byte[] imageData = service.downloadFile(name);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpeg"))
                .body(imageData);
    }

    @GetMapping("/fileSystem/search/{id}")
    public ResponseEntity<?> renderImageFromFileSystem(@PathVariable("id")String id) throws Exception {
        byte[] imageData = service.renderFile(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpeg"))
                .body(imageData);
    }

}
