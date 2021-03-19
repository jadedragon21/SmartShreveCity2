package com.tts.capstone.SmartShreveCity2.MappApp.model;

import lombok.Data;

import java.util.List;

@Data
public class GeocodingResponse {
    private List<Geocoding> results;
}