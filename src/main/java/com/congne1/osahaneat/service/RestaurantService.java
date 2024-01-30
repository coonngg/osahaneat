package com.congne1.osahaneat.service;

import com.congne1.osahaneat.dto.RestaurantDto;
import com.congne1.osahaneat.entity.RatingFood;
import com.congne1.osahaneat.entity.RatingRestaurant;
import com.congne1.osahaneat.entity.Restaurant;
import com.congne1.osahaneat.repository.RestaurantRepository;
import com.congne1.osahaneat.service.imp.FileServiceImp;
import com.congne1.osahaneat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    FileServiceImp fileServiceImp;
    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean is_freedhip, String address, String open_date) {
        boolean isInsertSucess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if(isSaveFileSuccess){
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDesc(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setFreeship(is_freedhip);
                restaurant.setAddress(address);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");// chuyen kieu string ve date
                Date openDate =  simpleDateFormat.parse(open_date);
                restaurant.setOpenDate(openDate);
                restaurantRepository.save(restaurant);
                isInsertSucess = true;
            }
        }catch (Exception e){
            System.out.println("Error insert restaurant "+e.getMessage());
        }

        return isInsertSucess;
    }

    @Override
    public List<RestaurantDto> getHomePageRestaurant() {
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0,6);//lấy trang số 0, lấy ra 6 item
        Page<Restaurant> listdata = restaurantRepository.findAll(pageRequest);
        for (Restaurant data:listdata) {
            RestaurantDto restaurantDto = new RestaurantDto();
            restaurantDto.setImage(data.getImage());
            restaurantDto.setTitle(data.getTitle());
            restaurantDto.setSubtitle(data.getSubtitle());
            restaurantDto.setFreeShip(data.isFreeship());
            restaurantDto.setRating(Double.parseDouble(String.format("%.1f",calculatorRating(data.getLisRatingRestaurant()))));
            restaurantDtos.add(restaurantDto);
        }
        return restaurantDtos;
    }

    private double calculatorRating(Set<RatingRestaurant> listRating){
        double totalpoint = 0;
        for (RatingRestaurant data:listRating) {
            totalpoint += data.getRatePoint();
        }
        return totalpoint/listRating.size();
    }
}
