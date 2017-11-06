package com.homeaway.homeawayapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {

    @SerializedName("datetime_tbd")
    @Expose
    private Boolean datetimeTbd;
    @SerializedName("announce_date")
    @Expose
    private String announceDate;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
//    @SerializedName("taxonomies")
//    @Expose
//    private List<Taxonomy> taxonomies = null;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("time_tbd")
    @Expose
    private Boolean timeTbd;
    @SerializedName("id")
    @Expose
    private Integer id;
//    @SerializedName("stats")
//    @Expose
//    private Stats stats;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date_tbd")
    @Expose
    private Boolean dateTbd;
    @SerializedName("datetime_utc")
    @Expose
    private String datetimeUtc;
    @SerializedName("is_open")
    @Expose
    private Boolean isOpen;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("performers")
    @Expose
    private List<Performer> performers = null;
    @SerializedName("visible_until_utc")
    @Expose
    private String visibleUntilUtc;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("short_title")
    @Expose
    private String shortTitle;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("datetime_local")
    @Expose
    private String datetimeLocal;
    @SerializedName("url")
    @Expose
    private String url;

    public Boolean getDatetimeTbd() {
        return datetimeTbd;
    }

    public void setDatetimeTbd(Boolean datetimeTbd) {
        this.datetimeTbd = datetimeTbd;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    /*public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
    }*/

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Boolean getTimeTbd() {
        return timeTbd;
    }

    public void setTimeTbd(Boolean timeTbd) {
        this.timeTbd = timeTbd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDateTbd() {
        return dateTbd;
    }

    public void setDateTbd(Boolean dateTbd) {
        this.dateTbd = dateTbd;
    }

    public String getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(String datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public String getVisibleUntilUtc() {
        return visibleUntilUtc;
    }

    public void setVisibleUntilUtc(String visibleUntilUtc) {
        this.visibleUntilUtc = visibleUntilUtc;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatetimeLocal() {
        return datetimeLocal;
    }

    public void setDatetimeLocal(String datetimeLocal) {
        this.datetimeLocal = datetimeLocal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
