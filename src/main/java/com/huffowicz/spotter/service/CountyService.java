package com.huffowicz.spotter.service;

import java.util.ArrayList;
import java.util.List;

import com.huffowicz.spotter.model.County;
import org.springframework.stereotype.Service;

@Service
public class CountyService {

    public List<County> getAllCounties() {
        List<County> counties = new ArrayList<>();
        // Add sample data
        counties.add(new County("County1", "#ff0000", "40.7128", "-74.0060"));
        counties.add(new County("County2", "#00ff00", "40.7128", "-74.0060"));
        // Add more counties
        return counties;
    }
}