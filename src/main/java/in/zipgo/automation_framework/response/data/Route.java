package in.zipgo.automation_framework.response.data;

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
    "id",
    "name",
    "non_operation",
    "vote_received",
    "vote_required",
    "code",
    "ondemand",
    "stop_points"
})
public class Route {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("non_operation")
    private Boolean nonOperation;
    @JsonProperty("vote_received")
    private Integer voteReceived;
    @JsonProperty("vote_required")
    private Integer voteRequired;
    @JsonProperty("code")
    private String code;
    @JsonProperty("ondemand")
    private Boolean ondemand;
    @JsonProperty("stop_points")
    private List<StopPoint> stopPoints = null;
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

    @JsonProperty("non_operation")
    public Boolean getNonOperation() {
        return nonOperation;
    }

    @JsonProperty("non_operation")
    public void setNonOperation(Boolean nonOperation) {
        this.nonOperation = nonOperation;
    }

    @JsonProperty("vote_received")
    public Integer getVoteReceived() {
        return voteReceived;
    }

    @JsonProperty("vote_received")
    public void setVoteReceived(Integer voteReceived) {
        this.voteReceived = voteReceived;
    }

    @JsonProperty("vote_required")
    public Integer getVoteRequired() {
        return voteRequired;
    }

    @JsonProperty("vote_required")
    public void setVoteRequired(Integer voteRequired) {
        this.voteRequired = voteRequired;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("ondemand")
    public Boolean getOndemand() {
        return ondemand;
    }

    @JsonProperty("ondemand")
    public void setOndemand(Boolean ondemand) {
        this.ondemand = ondemand;
    }

    @JsonProperty("stop_points")
    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }

    @JsonProperty("stop_points")
    public void setStopPoints(List<StopPoint> stopPoints) {
        this.stopPoints = stopPoints;
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
