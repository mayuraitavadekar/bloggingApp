package com.example.bloggingapp.controllers;

import com.example.bloggingapp.payloads.FileResponse;
import com.example.bloggingapp.services.FileService;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(
            @RequestParam("image")MultipartFile image
            )
    {
        String fileName = null;

        try {
            fileName = this.fileService.uploadImage(path, image);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null, "error in file upload"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<FileResponse>(new FileResponse(fileName, "image is uploaded successfully"), HttpStatus.OK);

    }

    // method to serve file
    @GetMapping(value = "/images/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadFile(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {
        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    }
}
