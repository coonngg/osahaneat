package com.congne1.osahaneat.service;

import com.congne1.osahaneat.dto.CategoryDto;
import com.congne1.osahaneat.dto.MenuDto;
import com.congne1.osahaneat.entity.Category;
import com.congne1.osahaneat.entity.Food;
import com.congne1.osahaneat.repository.CategoryRepository;
import com.congne1.osahaneat.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<CategoryDto> getCategoryHomePage() {
        PageRequest pageRequest = PageRequest.of(0,3,Sort.by("id"));
        Page<Category> listCategory = categoryRepository.findAll(pageRequest);
        List<CategoryDto> listCategoryDtos = new ArrayList<>();
        for (Category data:listCategory) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(data.getNameCate());
            List<MenuDto> menuDtos = new ArrayList<>();
            for (Food datafood:data.getListFood()) {
                MenuDto menuDto = new MenuDto();
                menuDto.setTitle(datafood.getTitle());
                menuDto.setFreeShip(datafood.isFreeShip());
                menuDto.setImage(datafood.getImage());
                menuDtos.add(menuDto);
            }

            categoryDto.setMenus(menuDtos);
            listCategoryDtos.add(categoryDto);
        }
        return listCategoryDtos;
    }
}
