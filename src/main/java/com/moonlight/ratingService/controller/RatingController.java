package com.moonlight.ratingService.controller;

import com.moonlight.commonutility.mappers.AppResponse;
import com.moonlight.ratingService.mappers.RatingRequest;
import com.moonlight.ratingService.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/ratings")
@Slf4j
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/health/check")
    public ResponseEntity<AppResponse> checkHealth() {
        return ResponseEntity.ok()
                .body(new AppResponse("Welcome to Rating Service!"));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<AppResponse> saveRating(@RequestBody RatingRequest request) {
        log.info("RatingRequest : {}", request);
        return ResponseEntity.ok()
                .body(new AppResponse(ratingService.saveRating(request)));
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<AppResponse> getAllRatings() {
        return ResponseEntity.ok()
                .body(new AppResponse(ratingService.getAllRatings()));
    }

    @GetMapping(value = "/getByUserId/{userId}")
    public ResponseEntity<AppResponse> getAllRatingsByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok()
                .body(new AppResponse(ratingService.getRatingByUserId(userId)));
    }

    @GetMapping(value = "/getByHotel/{hotelId}")
    public ResponseEntity<AppResponse> getAllRatingsByHotelId(@PathVariable Integer hotelId) {
        return ResponseEntity.ok()
                .body(new AppResponse(ratingService.getRatingsByHotelId(hotelId)));
    }

}
