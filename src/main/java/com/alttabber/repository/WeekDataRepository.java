package com.alttabber.repository;

import com.alttabber.data.WeekData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeekDataRepository extends MongoRepository<WeekData, String> {



}
