package com.example.harshit.part1;

/**
 * Created by Harshit on 1/21/2018.
 */
import java.util.List;
import retrofit2.http.GET;
import io.reactivex.Observable;

public interface Service {

    @GET("jsonparsetutorial.txt")
    Observable<ImageModel> getimagedata();
}
