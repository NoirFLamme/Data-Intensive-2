package com.moviecatalogservice.resources;

import com.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        // Get all rated movie IDs

        // For each movie ID, call movie info service and get details
        return Collections.singletonList(new CatalogItem("Transformers", "Test", 4));
    }
}
