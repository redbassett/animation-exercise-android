package io.intrepid.animationexercise.rest;

import io.intrepid.animationexercise.models.CatResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RestApi {
    @GET("/api/images/get")
    Observable<CatResponse> getCats(@Query("results_per_page") int pageSize,
                                    @Query("format") String responseFormat,
                                    @Query("type") String imageFormats);
}
