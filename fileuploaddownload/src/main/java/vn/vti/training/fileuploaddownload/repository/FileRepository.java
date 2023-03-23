package vn.vti.training.fileuploaddownload.repository;

import org.springframework.stereotype.Repository;
import vn.vti.training.fileuploaddownload.entity.FileData;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FileRepository {
    private List<FileData> files = new ArrayList<>();

    public FileData saveFile(FileData data){
        files.add(data);
        return data;
    }

    public FileData findByName(String fileName){
        return files.stream().filter(file->file.getName().equalsIgnoreCase(fileName)).findFirst().orElse(null);
    }

    public FileData findById(String id){
        return files.stream().filter(file->file.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

}
