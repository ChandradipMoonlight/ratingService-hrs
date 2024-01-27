package com.moonlight.ratingService.service;

import com.moonlight.commonutility.exception.ResourceNotFoundException;
import com.moonlight.ratingService.collections.UserRating;
import com.moonlight.ratingService.mappers.RatingRequest;
import com.moonlight.ratingService.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public UserRating saveRating(RatingRequest request) {
        UserRating rating = createRating(request);
        log.info("Rating : {}", rating);
        return ratingRepository.save(rating);
    }

    @Override
    public List<UserRating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<UserRating> getRatingByUserId(Integer userId) {
        return ratingRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Rating", "UserId", String.valueOf(userId)));
    }

    @Override
    public List<UserRating> getRatingsByHotelId(Integer hotelId) {
        return ratingRepository.findByHotelId(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Rating", "HotelId", String.valueOf(hotelId)));
    }

    private UserRating createRating(RatingRequest request) {
        return UserRating.builder()
                .ratingId(getLatestRatingId())
                .hotelId(request.getHotelId())
                .userId(request.getUserId())
                .rating(request.getRating())
                .feedback(request.getFeedback())
                .build();
    }

    private Integer getLatestRatingId() {
        Integer id = ratingRepository.findAll()
                .stream()
                .map(rating -> rating.getRatingId())
                .max((id1, id2) -> id1.compareTo(id2))
                .orElse(0);
        log.info("creating latest RatingId : {}", id);
        return id + 1;
    }
}
