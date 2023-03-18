package com.be_casemd6.service;

import com.be_casemd6.model.Image;

import java.util.List;

public interface IImageService {
    Image save(Image image);
    List<Image> findByAccount_IdAAndStatusImg1(Integer accountId);
}
