package com.be_casemd6.service.impl;

import com.be_casemd6.model.Image;
import com.be_casemd6.repo.IImageRepo;
import com.be_casemd6.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageRepo iImageRepo;

    @Override
    public Image save(Image image) {
        return iImageRepo.save(image);
    }
}
