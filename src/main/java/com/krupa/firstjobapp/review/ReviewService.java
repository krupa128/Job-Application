package com.krupa.firstjobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long id);
    public boolean addReview(Long id,Review review);
    Review getReview(Long companyId,Long reviewId);
    boolean updateReview(Long companyId,Long reviewId,Review review);
    boolean delete(Long companyId, Long reviewId);
}
