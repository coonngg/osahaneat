package com.congne1.osahaneat.service.imp;

import com.congne1.osahaneat.dto.RestaurantDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantServiceImp {
    boolean insertRestaurant(MultipartFile file,
                             String  title ,
                             String subtitle ,
                             String description ,
                             boolean is_freedhip ,
                             String address ,
                             String open_date );
    List<RestaurantDto> getHomePageRestaurant();
}
