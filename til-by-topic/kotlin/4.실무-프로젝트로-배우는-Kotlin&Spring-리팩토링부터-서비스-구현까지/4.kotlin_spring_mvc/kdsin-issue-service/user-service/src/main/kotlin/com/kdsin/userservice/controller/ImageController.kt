package com.kdsin.userservice.controller

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.io.File
import java.io.FileInputStream

@Controller
@RequestMapping("/images")
class ImageController {

    @GetMapping("{filename}")
    fun image(@PathVariable filename: String): ResponseEntity<InputStreamResource> {
        val ext = filename.substring(filename.lastIndexOf(".") + 1)
        val file = File(ClassPathResource("/images/").file, filename)

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, "images/$ext")
            .body(InputStreamResource(FileInputStream(file)))

    }
}