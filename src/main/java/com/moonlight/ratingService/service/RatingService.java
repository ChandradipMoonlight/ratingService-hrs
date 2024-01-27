package com.moonlight.ratingService.service;

import com.moonlight.ratingService.collections.UserRating;
import com.moonlight.ratingService.mappers.RatingRequest;

import java.util.List;

public interface RatingService {

    //create
    UserRating saveRating(RatingRequest ratingRequest);

    //get all ratings
    List<UserRating> getAllRatings();

    //get all by userId
    List<UserRating> getRatingByUserId(Integer userId);

    //get all by hotelId
    List<UserRating> getRatingsByHotelId(Integer hotelId);

    //

}
