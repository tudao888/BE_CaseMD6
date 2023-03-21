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
        return iImageRepo.findByAccount_IdAAndStatusImg1(accountId);
    }

    @Override
    public List<Image> findByAccount_IdAAndStatusImg2(Integer accountId) {
        return iImageRepo.findByAccount_IdAAndStatusImg2(accountId);
    }


}
