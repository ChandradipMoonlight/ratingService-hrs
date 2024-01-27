package com.moonlight.ratingService.repository;

import com.moonlight.ratingService.collections.UserRating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends MongoRepository<UserRating, Integer> {

    Optional<List<UserRating>> findByUserId(Integer userId);

    Optional<List<UserRating>> findByHotelId(Integer hotelId);
}
