package com.moviecatalogservice.resources;

import com.moviecatalogservice.models.Movie;
import com.moviecatalogservice.services.TrendingService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trending")
public class TrendingMoveResource {

    private final TrendingService trendingService;

    public TrendingMoveResource(TrendingService trendingService) {
        this.trendingService = trendingService;
    }

    @RequestMapping
    public List<Movie> getTrendingMovies() {
        return trendingService.getTrendingMovies();
    }
}
