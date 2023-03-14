package com.be_casemd6.repo;

import com.be_casemd6.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepo extends JpaRepository<Image, Integer> {
}
