package com.carledwinti.travel.api.constants;

public class Constants {
    public static final String MESSAGE_SUCCESSFULLY = "Travel Api is running...";
    public static final String MESSAGE_SUCCESSFULLY_FROM_SERVICE = "Travel Api is running FROM Service...";
    public static final String URL_LOCAL = "http://localhost:";
    public static final String SLASH = "/";
    public static final String ENDPOINT_STATUS = "status";
    public static final String ENDPOINT_STATUS_FROM_SERVICE = ENDPOINT_STATUS + SLASH + "from-service";
    public static final String MAPPING_CONTROLLER_TRAVEL = "travels";
    public static final String MAPPING_CONTROLLER_TRAVEL_WITH_SERVICE = "travel-with-service";
    public static final String URL_REQUEST_TRAVEL_STATUS = SLASH + MAPPING_CONTROLLER_TRAVEL + SLASH + ENDPOINT_STATUS;
    public static final String URL_REQUEST_TRAVEL_STATUS_FROM_SERVICE = SLASH + MAPPING_CONTROLLER_TRAVEL_WITH_SERVICE + SLASH + ENDPOINT_STATUS_FROM_SERVICE;
    private static final String MAPPING_CONTROLLER_BOOKING = "bookings";
    public static final String URL_BOOKING_ALL = SLASH + MAPPING_CONTROLLER_BOOKING;
}
