package com.moonlight.ratingService.mappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingRequest {

    private Integer userId;
    private Integer hotelId;
    private float rating;
    private String feedback;

}
