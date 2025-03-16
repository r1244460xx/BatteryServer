package com.symbol.BatteryServer.repository;

import com.symbol.BatteryServer.model.Battery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Integer> {

    @Query(value = "SELECT * FROM battery ORDER BY id DESC", nativeQuery = true)
    List<Battery> findByIdDesc(Pageable pageable);
}
