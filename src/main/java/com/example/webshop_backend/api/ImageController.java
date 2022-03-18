package com.example.webshop_backend.api;

import com.example.webshop_backend.service.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @PostMapping("/img")
    public String uploadImg(@RequestParam("file")MultipartFile file) throws IOException {
        imageService.uploadImage(file);

        return "file uploaded";
    }

//    @PostMapping("/img")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
//
//        imageService.uploadImage(file);
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file.getOriginalFilename() + "!");
//
//        return "image uploaded!";
//    }

}
