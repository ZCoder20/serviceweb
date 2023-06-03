package com.example.postgres.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponseData {
    private String fileName;
    private String fileUrl;
    private String fileType;
    private Long fileSize;
}
