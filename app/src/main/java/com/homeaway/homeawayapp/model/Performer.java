package com.homeaway.homeawayapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Performer {

    @SerializedName("image_license")
    @Expose
    private Object imageLicense;
    @SerializedName("primary")
    @Expose
    private Boolean primary;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    /*@SerializedName("taxonomies")
    @Expose
    private List<Taxonomy_> taxonomies = null;*/
    @SerializedName("has_upcoming_events")
    @Expose
    private Boolean hasUpcomingEvents;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("home_venue_id")
    @Expose
    private Object homeVenueId;
    @SerializedName("slug")
    @Expose
    private String slug;
    /*@SerializedName("stats")
    @Expose
    private Stats_ stats;*/
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("divisions")
    @Expose
    private Object divisions;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("colors")
    @Expose
    private Object colors;
    @SerializedName("num_upcoming_events")
    @Expose
    private Integer numUpcomingEvents;
    @SerializedName("image_attribution")
    @Expose
    private String imageAttribution;
    /*@SerializedName("images")
    @Expose
    private Images images;*/

    public Object getImageLicense() {
        return imageLicense;
    }

    public void setImageLicense(Object imageLicense) {
        this.imageLicense = imageLicense;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /*public List<Taxonomy_> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy_> taxonomies) {
        this.taxonomies = taxonomies;
    }*/

    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getHomeVenueId() {
        return homeVenueId;
    }

    public void setHomeVenueId(Object homeVenueId) {
        this.homeVenueId = homeVenueId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    /*public Stats_ getStats() {
        return stats;
    }

    public void setStats(Stats_ stats) {
        this.stats = stats;
    }*/

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getDivisions() {
        return divisions;
    }

    public void setDivisions(Object divisions) {
        this.divisions = divisions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getColors() {
        return colors;
    }

    public void setColors(Object colors) {
        this.colors = colors;
    }

    public Integer getNumUpcomingEvents() {
        return numUpcomingEvents;
    }

    public void setNumUpcomingEvents(Integer numUpcomingEvents) {
        this.numUpcomingEvents = numUpcomingEvents;
    }

    public String getImageAttribution() {
        return imageAttribution;
    }

    public void setImageAttribution(String imageAttribution) {
        this.imageAttribution = imageAttribution;
    }

    /*public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }*/

}
