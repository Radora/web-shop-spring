package com.example.webshop_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageService {
    public void uploadImage(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\esho_\\Desktop\\webshop_img\\" + file.getOriginalFilename()));
    }
}
