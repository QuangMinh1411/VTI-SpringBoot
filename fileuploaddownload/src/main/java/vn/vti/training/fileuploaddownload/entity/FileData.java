package vn.vti.training.fileuploaddownload.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileData {
    private String id;
    private String name;
    private String type;
    private String filePath;

}
