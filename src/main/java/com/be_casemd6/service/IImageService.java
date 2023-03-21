package com.be_casemd6.service;

import com.be_casemd6.model.Image;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImageService {
    Image save(Image image);
    List<Image> findByAccount_IdAAndStatusImg1(Integer accountId);
    List<Image> findByAccount_IdAAndStatusImg2(Integer accountId);

}
