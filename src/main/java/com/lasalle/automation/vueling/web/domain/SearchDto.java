package com.lasalle.automation.vueling.web.domain;

public class SearchDto {

    private String origin;
    private String destination;
    private String outboundFly;
    private String returnFly;
    private String passengers;

    public SearchDto() {

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOutboundFly() {
        return outboundFly;
    }

    public void setOutboundFly(String outboundFly) {
        this.outboundFly = outboundFly;
    }

    public String getReturnFly() {
        return returnFly;
    }

    public void setReturnFly(String returnFly) {
        this.returnFly = returnFly;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }
}
