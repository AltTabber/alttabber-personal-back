package com.alttabber.repository;

import com.alttabber.data.BlogDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BlogsRepository extends MongoRepository<BlogDto, String> {

    Optional<BlogDto> findById(String id);

    @Query("{'createDate' : { $gte: ?0, $lte: ?1 } }")
    List<BlogDto> findByDate(Date beforeDate, Date afterDate);
}
