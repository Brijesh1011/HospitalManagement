package com.prectice.hospitalmanagement.repository;

import com.prectice.hospitalmanagement.entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepository extends JpaRepository<Illness,Long> {

}
