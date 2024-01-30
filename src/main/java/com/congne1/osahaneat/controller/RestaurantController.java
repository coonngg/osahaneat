package com.congne1.osahaneat.controller;

import com.congne1.osahaneat.paylod.ResponseData;
import com.congne1.osahaneat.service.FileService;
import com.congne1.osahaneat.service.RestaurantService;
import com.congne1.osahaneat.service.imp.FileServiceImp;
import com.congne1.osahaneat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin("*")

@RestController
@RequestMapping("/retaurant")
public class RestaurantController {
    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    RestaurantServiceImp restaurantServiceImp;
    @PostMapping()
    public ResponseEntity<?> createRestaurant(
            @RequestParam MultipartFile file,
            @RequestParam String  title ,
            @RequestParam String subtitle ,
            @RequestParam String description ,
            @RequestParam boolean is_freedhip ,
            @RequestParam String address ,
            @RequestParam String open_date ){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = restaurantServiceImp.insertRestaurant(file,title,subtitle,description,is_freedhip,address,open_date);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getHomeRestaurant(){
        ResponseData responseData = new ResponseData();
        responseData.setData(restaurantServiceImp.getHomePageRestaurant());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping ("/file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename){
        Resource resource = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }
}
