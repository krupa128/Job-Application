package com.krupa.firstjobapp.review;

import com.krupa.firstjobapp.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review){
         boolean isReviewSaved = reviewService.addReview(companyId,review);
         if(isReviewSaved){
             return new ResponseEntity<>("Review added successfully",HttpStatus.OK);
         }else {
             return new ResponseEntity<>("Review Not Saved",HttpStatus.NOT_FOUND);
         }
    }

    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review){
        boolean isReviewsUpdated = reviewService.updateReview(companyId,reviewId,review);
        if (isReviewsUpdated){
            return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not  updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean isreviewDeleted = reviewService.delete(companyId,reviewId);
        if(isreviewDeleted){
            return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Review Not deleted",HttpStatus.NOT_FOUND);
        }
    }
}
