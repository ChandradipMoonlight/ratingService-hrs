package com.moonlight.ratingService.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "UserRating")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRating {
    @Transient
    public static final String SEQUENCE_NAME = "rating_sequence";
    @Id
    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private float rating;
    private String feedback;
}
