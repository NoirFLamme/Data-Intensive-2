package com.moviecatalogservice.services;


import com.moviecatalogservice.models.Movie;
import com.trending.Movies;
import com.trending.RequestParams;
import com.trending.TrendingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrendingService {

    public List<Movie> getTrendingMovies() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext()
                .build();

        TrendingServiceGrpc.TrendingServiceBlockingStub stub
                = TrendingServiceGrpc.newBlockingStub(channel);

        Movies res = stub.getTop10Trending(RequestParams.newBuilder().build());
        channel.shutdown();

        return res.getMoviesList().stream().map((movie -> {
            Movie m = new Movie();
            m.setMovieId(movie.getMovieId());
            return m;
        })).collect(Collectors.toList());
    }
}
