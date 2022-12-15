

package com.exmple.dto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "city",
    "update",
    "forecast"
})
public class ApiMeteoResponse {

    @JsonProperty("city")
    private City city;
    @JsonProperty("update")
    private String update;
    @JsonProperty("forecast")
    private List<Forecast> forecast = new ArrayList<Forecast>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    @JsonProperty("update")
    public String getUpdate() {
        return update;
    }

    @JsonProperty("update")
    public void setUpdate(String update) {
        this.update = update;
    }

    @JsonProperty("forecast")
    public List<Forecast> getForecast() {
        return forecast;
    }

    @JsonProperty("forecast")
    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
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
        sb.append(ApiMeteoResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("update");
        sb.append('=');
        sb.append(((this.update == null)?"<null>":this.update));
        sb.append(',');
        sb.append("forecast");
        sb.append('=');
        sb.append(((this.forecast == null)?"<null>":this.forecast));
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
        result = ((result* 31)+((this.update == null)? 0 :this.update.hashCode()));
        result = ((result* 31)+((this.forecast == null)? 0 :this.forecast.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApiMeteoResponse) == false) {
            return false;
        }
        ApiMeteoResponse rhs = ((ApiMeteoResponse) other);
        return (((((this.update == rhs.update)||((this.update!= null)&&this.update.equals(rhs.update)))&&((this.forecast == rhs.forecast)||((this.forecast!= null)&&this.forecast.equals(rhs.forecast))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))));
    }

}
