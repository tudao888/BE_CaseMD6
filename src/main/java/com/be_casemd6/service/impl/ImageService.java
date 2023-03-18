package com.be_casemd6.service.impl;

import com.be_casemd6.model.Image;
import com.be_casemd6.model.dto.ImageUrlDTO;
import com.be_casemd6.repo.IImageRepo;
import com.be_casemd6.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageRepo iImageRepo;

    @Override
    public Image save(Image image) {
        return iImageRepo.save(image);
    }

    @Override
    public List<Image> findByAccount_IdAAndStatusImg1(Integer accountId) {
        List<ImageUrlDTO> ListUrl= new ArrayList<>();
        for (Image image: iImageRepo.findByAccount_IdAAndStatusImg1(accountId)) {
            ImageUrlDTO imageUrlDTO=new ImageUrlDTO(image.getUrl());
            ListUrl.add(imageUrlDTO);
        }
        return iImageRepo.findByAccount_IdAAndStatusImg1(accountId);
    }
}
