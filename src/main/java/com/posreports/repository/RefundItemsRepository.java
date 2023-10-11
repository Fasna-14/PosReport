package com.posreports.repository;

import com.posreports.entity.RefundItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RefundItemsRepository extends JpaRepository<RefundItems,Long> {
    List<RefundItems> findByAccessDateBetween(Date startDate, Date endDate);
}
