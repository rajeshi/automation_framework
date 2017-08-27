package in.zipgo.automation_framework.response.data;

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
    "id",
    "name",
    "code",
    "position",
    "arrival_time",
    "arrival_text",
    "departure_time",
    "departure_text"
})
public class StopPoint {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private String code;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("arrival_time")
    private Integer arrivalTime;
    @JsonProperty("arrival_text")
    private String arrivalText;
    @JsonProperty("departure_time")
    private Integer departureTime;
    @JsonProperty("departure_text")
    private String departureText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("arrival_time")
    public Integer getArrivalTime() {
        return arrivalTime;
    }

    @JsonProperty("arrival_time")
    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @JsonProperty("arrival_text")
    public String getArrivalText() {
        return arrivalText;
    }

    @JsonProperty("arrival_text")
    public void setArrivalText(String arrivalText) {
        this.arrivalText = arrivalText;
    }

    @JsonProperty("departure_time")
    public Integer getDepartureTime() {
        return departureTime;
    }

    @JsonProperty("departure_time")
    public void setDepartureTime(Integer departureTime) {
        this.departureTime = departureTime;
    }

    @JsonProperty("departure_text")
    public String getDepartureText() {
        return departureText;
    }

    @JsonProperty("departure_text")
    public void setDepartureText(String departureText) {
        this.departureText = departureText;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
