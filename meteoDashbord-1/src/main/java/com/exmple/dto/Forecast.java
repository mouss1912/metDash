

package com.exmple.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "insee",
    "cp",
    "latitude",
    "longitude",
    "datetime",
    "temp2m",
    "rh2m",
    "wind10m",
    "gust10m",
    "dirwind10m",
    "rr10",
    "rr1",
    "probarain",
    "weather",
    "probafrost",
    "probafog",
    "probawind70",
    "probawind100",
    "tsoil1",
    "tsoil2",
    "gustx",
    "iso0"
})
public class Forecast {

    @JsonProperty("insee")
    private String insee;
    @JsonProperty("cp")
    private Integer cp;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("temp2m")
    private Integer temp2m;
    @JsonProperty("rh2m")
    private Integer rh2m;
    @JsonProperty("wind10m")
    private Integer wind10m;
    @JsonProperty("gust10m")
    private Integer gust10m;
    @JsonProperty("dirwind10m")
    private Integer dirwind10m;
    @JsonProperty("rr10")
    private Integer rr10;
    @JsonProperty("rr1")
    private Integer rr1;
    @JsonProperty("probarain")
    private Integer probarain;
    @JsonProperty("weather")
    private Integer weather;
    @JsonProperty("probafrost")
    private Integer probafrost;
    @JsonProperty("probafog")
    private Integer probafog;
    @JsonProperty("probawind70")
    private Integer probawind70;
    @JsonProperty("probawind100")
    private Integer probawind100;
    @JsonProperty("tsoil1")
    private Integer tsoil1;
    @JsonProperty("tsoil2")
    private Integer tsoil2;
    @JsonProperty("gustx")
    private Integer gustx;
    @JsonProperty("iso0")
    private Integer iso0;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("insee")
    public String getInsee() {
        return insee;
    }

    @JsonProperty("insee")
    public void setInsee(String insee) {
        this.insee = insee;
    }

    @JsonProperty("cp")
    public Integer getCp() {
        return cp;
    }

    @JsonProperty("cp")
    public void setCp(Integer cp) {
        this.cp = cp;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("datetime")
    public String getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @JsonProperty("temp2m")
    public Integer getTemp2m() {
        return temp2m;
    }

    @JsonProperty("temp2m")
    public void setTemp2m(Integer temp2m) {
        this.temp2m = temp2m;
    }

    @JsonProperty("rh2m")
    public Integer getRh2m() {
        return rh2m;
    }

    @JsonProperty("rh2m")
    public void setRh2m(Integer rh2m) {
        this.rh2m = rh2m;
    }

    @JsonProperty("wind10m")
    public Integer getWind10m() {
        return wind10m;
    }

    @JsonProperty("wind10m")
    public void setWind10m(Integer wind10m) {
        this.wind10m = wind10m;
    }

    @JsonProperty("gust10m")
    public Integer getGust10m() {
        return gust10m;
    }

    @JsonProperty("gust10m")
    public void setGust10m(Integer gust10m) {
        this.gust10m = gust10m;
    }

    @JsonProperty("dirwind10m")
    public Integer getDirwind10m() {
        return dirwind10m;
    }

    @JsonProperty("dirwind10m")
    public void setDirwind10m(Integer dirwind10m) {
        this.dirwind10m = dirwind10m;
    }

    @JsonProperty("rr10")
    public Integer getRr10() {
        return rr10;
    }

    @JsonProperty("rr10")
    public void setRr10(Integer rr10) {
        this.rr10 = rr10;
    }

    @JsonProperty("rr1")
    public Integer getRr1() {
        return rr1;
    }

    @JsonProperty("rr1")
    public void setRr1(Integer rr1) {
        this.rr1 = rr1;
    }

    @JsonProperty("probarain")
    public Integer getProbarain() {
        return probarain;
    }

    @JsonProperty("probarain")
    public void setProbarain(Integer probarain) {
        this.probarain = probarain;
    }

    @JsonProperty("weather")
    public Integer getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(Integer weather) {
        this.weather = weather;
    }

    @JsonProperty("probafrost")
    public Integer getProbafrost() {
        return probafrost;
    }

    @JsonProperty("probafrost")
    public void setProbafrost(Integer probafrost) {
        this.probafrost = probafrost;
    }

    @JsonProperty("probafog")
    public Integer getProbafog() {
        return probafog;
    }

    @JsonProperty("probafog")
    public void setProbafog(Integer probafog) {
        this.probafog = probafog;
    }

    @JsonProperty("probawind70")
    public Integer getProbawind70() {
        return probawind70;
    }

    @JsonProperty("probawind70")
    public void setProbawind70(Integer probawind70) {
        this.probawind70 = probawind70;
    }

    @JsonProperty("probawind100")
    public Integer getProbawind100() {
        return probawind100;
    }

    @JsonProperty("probawind100")
    public void setProbawind100(Integer probawind100) {
        this.probawind100 = probawind100;
    }

    @JsonProperty("tsoil1")
    public Integer getTsoil1() {
        return tsoil1;
    }

    @JsonProperty("tsoil1")
    public void setTsoil1(Integer tsoil1) {
        this.tsoil1 = tsoil1;
    }

    @JsonProperty("tsoil2")
    public Integer getTsoil2() {
        return tsoil2;
    }

    @JsonProperty("tsoil2")
    public void setTsoil2(Integer tsoil2) {
        this.tsoil2 = tsoil2;
    }

    @JsonProperty("gustx")
    public Integer getGustx() {
        return gustx;
    }

    @JsonProperty("gustx")
    public void setGustx(Integer gustx) {
        this.gustx = gustx;
    }

    @JsonProperty("iso0")
    public Integer getIso0() {
        return iso0;
    }

    @JsonProperty("iso0")
    public void setIso0(Integer iso0) {
        this.iso0 = iso0;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Forecast.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("insee");
        sb.append('=');
        sb.append(((this.insee == null)?"<null>":this.insee));
        sb.append(',');
        sb.append("cp");
        sb.append('=');
        sb.append(((this.cp == null)?"<null>":this.cp));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.latitude == null)?"<null>":this.latitude));
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.longitude == null)?"<null>":this.longitude));
        sb.append(',');
        sb.append("datetime");
        sb.append('=');
        sb.append(((this.datetime == null)?"<null>":this.datetime));
        sb.append(',');
        sb.append("temp2m");
        sb.append('=');
        sb.append(((this.temp2m == null)?"<null>":this.temp2m));
        sb.append(',');
        sb.append("rh2m");
        sb.append('=');
        sb.append(((this.rh2m == null)?"<null>":this.rh2m));
        sb.append(',');
        sb.append("wind10m");
        sb.append('=');
        sb.append(((this.wind10m == null)?"<null>":this.wind10m));
        sb.append(',');
        sb.append("gust10m");
        sb.append('=');
        sb.append(((this.gust10m == null)?"<null>":this.gust10m));
        sb.append(',');
        sb.append("dirwind10m");
        sb.append('=');
        sb.append(((this.dirwind10m == null)?"<null>":this.dirwind10m));
        sb.append(',');
        sb.append("rr10");
        sb.append('=');
        sb.append(((this.rr10 == null)?"<null>":this.rr10));
        sb.append(',');
        sb.append("rr1");
        sb.append('=');
        sb.append(((this.rr1 == null)?"<null>":this.rr1));
        sb.append(',');
        sb.append("probarain");
        sb.append('=');
        sb.append(((this.probarain == null)?"<null>":this.probarain));
        sb.append(',');
        sb.append("weather");
        sb.append('=');
        sb.append(((this.weather == null)?"<null>":this.weather));
        sb.append(',');
        sb.append("probafrost");
        sb.append('=');
        sb.append(((this.probafrost == null)?"<null>":this.probafrost));
        sb.append(',');
        sb.append("probafog");
        sb.append('=');
        sb.append(((this.probafog == null)?"<null>":this.probafog));
        sb.append(',');
        sb.append("probawind70");
        sb.append('=');
        sb.append(((this.probawind70 == null)?"<null>":this.probawind70));
        sb.append(',');
        sb.append("probawind100");
        sb.append('=');
        sb.append(((this.probawind100 == null)?"<null>":this.probawind100));
        sb.append(',');
        sb.append("tsoil1");
        sb.append('=');
        sb.append(((this.tsoil1 == null)?"<null>":this.tsoil1));
        sb.append(',');
        sb.append("tsoil2");
        sb.append('=');
        sb.append(((this.tsoil2 == null)?"<null>":this.tsoil2));
        sb.append(',');
        sb.append("gustx");
        sb.append('=');
        sb.append(((this.gustx == null)?"<null>":this.gustx));
        sb.append(',');
        sb.append("iso0");
        sb.append('=');
        sb.append(((this.iso0 == null)?"<null>":this.iso0));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.probafrost == null)? 0 :this.probafrost.hashCode()));
        result = ((result* 31)+((this.rh2m == null)? 0 :this.rh2m.hashCode()));
        result = ((result* 31)+((this.tsoil1 == null)? 0 :this.tsoil1 .hashCode()));
        result = ((result* 31)+((this.tsoil2 == null)? 0 :this.tsoil2 .hashCode()));
        result = ((result* 31)+((this.probawind100 == null)? 0 :this.probawind100 .hashCode()));
        result = ((result* 31)+((this.latitude == null)? 0 :this.latitude.hashCode()));
        result = ((result* 31)+((this.probawind70 == null)? 0 :this.probawind70 .hashCode()));
        result = ((result* 31)+((this.wind10m == null)? 0 :this.wind10m.hashCode()));
        result = ((result* 31)+((this.rr10 == null)? 0 :this.rr10 .hashCode()));
        result = ((result* 31)+((this.gustx == null)? 0 :this.gustx.hashCode()));
        result = ((result* 31)+((this.cp == null)? 0 :this.cp.hashCode()));
        result = ((result* 31)+((this.gust10m == null)? 0 :this.gust10m.hashCode()));
        result = ((result* 31)+((this.dirwind10m == null)? 0 :this.dirwind10m.hashCode()));
        result = ((result* 31)+((this.rr1 == null)? 0 :this.rr1 .hashCode()));
        result = ((result* 31)+((this.probarain == null)? 0 :this.probarain.hashCode()));
        result = ((result* 31)+((this.datetime == null)? 0 :this.datetime.hashCode()));
        result = ((result* 31)+((this.probafog == null)? 0 :this.probafog.hashCode()));
        result = ((result* 31)+((this.insee == null)? 0 :this.insee.hashCode()));
        result = ((result* 31)+((this.weather == null)? 0 :this.weather.hashCode()));
        result = ((result* 31)+((this.iso0 == null)? 0 :this.iso0 .hashCode()));
        result = ((result* 31)+((this.temp2m == null)? 0 :this.temp2m.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.longitude == null)? 0 :this.longitude.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Forecast) == false) {
            return false;
        }
        Forecast rhs = ((Forecast) other);
        return ((((((((((((((((((((((((this.probafrost == rhs.probafrost)||((this.probafrost!= null)&&this.probafrost.equals(rhs.probafrost)))&&((this.rh2m == rhs.rh2m)||((this.rh2m!= null)&&this.rh2m.equals(rhs.rh2m))))&&((this.tsoil1 == rhs.tsoil1)||((this.tsoil1 != null)&&this.tsoil1 .equals(rhs.tsoil1))))&&((this.tsoil2 == rhs.tsoil2)||((this.tsoil2 != null)&&this.tsoil2 .equals(rhs.tsoil2))))&&((this.probawind100 == rhs.probawind100)||((this.probawind100 != null)&&this.probawind100 .equals(rhs.probawind100))))&&((this.latitude == rhs.latitude)||((this.latitude!= null)&&this.latitude.equals(rhs.latitude))))&&((this.probawind70 == rhs.probawind70)||((this.probawind70 != null)&&this.probawind70 .equals(rhs.probawind70))))&&((this.wind10m == rhs.wind10m)||((this.wind10m!= null)&&this.wind10m.equals(rhs.wind10m))))&&((this.rr10 == rhs.rr10)||((this.rr10 != null)&&this.rr10 .equals(rhs.rr10))))&&((this.gustx == rhs.gustx)||((this.gustx!= null)&&this.gustx.equals(rhs.gustx))))&&((this.cp == rhs.cp)||((this.cp!= null)&&this.cp.equals(rhs.cp))))&&((this.gust10m == rhs.gust10m)||((this.gust10m!= null)&&this.gust10m.equals(rhs.gust10m))))&&((this.dirwind10m == rhs.dirwind10m)||((this.dirwind10m!= null)&&this.dirwind10m.equals(rhs.dirwind10m))))&&((this.rr1 == rhs.rr1)||((this.rr1 != null)&&this.rr1 .equals(rhs.rr1))))&&((this.probarain == rhs.probarain)||((this.probarain!= null)&&this.probarain.equals(rhs.probarain))))&&((this.datetime == rhs.datetime)||((this.datetime!= null)&&this.datetime.equals(rhs.datetime))))&&((this.probafog == rhs.probafog)||((this.probafog!= null)&&this.probafog.equals(rhs.probafog))))&&((this.insee == rhs.insee)||((this.insee!= null)&&this.insee.equals(rhs.insee))))&&((this.weather == rhs.weather)||((this.weather!= null)&&this.weather.equals(rhs.weather))))&&((this.iso0 == rhs.iso0)||((this.iso0 != null)&&this.iso0 .equals(rhs.iso0))))&&((this.temp2m == rhs.temp2m)||((this.temp2m!= null)&&this.temp2m.equals(rhs.temp2m))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.longitude == rhs.longitude)||((this.longitude!= null)&&this.longitude.equals(rhs.longitude))));
    }

}
