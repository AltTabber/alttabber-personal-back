package com.alttabber.repository;

import com.alttabber.data.WeekData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;

public interface WeekDataRepository extends MongoRepository<WeekData, String> {

    @Query("{'dateStart' : { $gte: ?0 }, 'dateEnd' : { $lte: ?0 } }")
    WeekData findByEnteredDate(Date createDate);
}
