package com.be_casemd6.repo;

import com.be_casemd6.model.Provision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvisionRepo extends JpaRepository<Provision, Integer> {
    @Query(nativeQuery = true, value = "SELECT * from provision where provision.category_id = 1")
    List<Provision> findAllBasicProvision();

    @Query(nativeQuery = true, value = "SELECT * from provision where provision.category_id = 2")
    List<Provision> findAllFreeProvision();

    @Query(nativeQuery = true, value = "SELECT * from provision where provision.category_id = 3")
    List<Provision> findAllExtendProvision();
}
