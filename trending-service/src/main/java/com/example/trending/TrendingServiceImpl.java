package com.example.trending;

import com.trending.Movie;
import com.trending.Movies;
import com.trending.TrendingServiceGrpc;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class TrendingServiceImpl extends TrendingServiceGrpc.TrendingServiceImplBase{

    @Override
    public void getTop10Trending(com.trending.RequestParams request,
                                 io.grpc.stub.StreamObserver<com.trending.Movies> responseObserver) {
        final RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8083/ratings/1";
        UserRating ratings = restTemplate.getForObject(url, UserRating.class);

        Movies movies = Movies.newBuilder()
                .addAllMovies(
                        ratings.getRatings().stream()
                        .map((rating -> {
                            String id = rating.getMovieId();
                            return Movie.newBuilder().setMovieId(id).build();
                        })).collect(Collectors.toCollection(ArrayList::new))
                )
                .build();

        responseObserver.onNext(movies);
        responseObserver.onCompleted();
    }

}
