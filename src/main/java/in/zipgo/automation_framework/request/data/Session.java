package in.zipgo.automation_framework.request.data;

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
    "oauth_type",
    "oauth_id",
    "oauth_token",
    "oauth_city",
    "oauth_birth_date",
    "os",
    "token",
    "app_version"
})
public class Session {

    @JsonProperty("oauth_type")
    private String oauthType;
    @JsonProperty("oauth_id")
    private String oauthId;
    @JsonProperty("oauth_token")
    private String oauthToken;
    @JsonProperty("oauth_city")
    private String oauthCity;
    @JsonProperty("oauth_birth_date")
    private String oauthBirthDate;
    @JsonProperty("os")
    private String os;
    @JsonProperty("token")
    private String token;
    @JsonProperty("app_version")
    private String appVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("oauth_type")
    public String getOauthType() {
        return oauthType;
    }

    @JsonProperty("oauth_type")
    public void setOauthType(String oauthType) {
        this.oauthType = oauthType;
    }

    @JsonProperty("oauth_id")
    public String getOauthId() {
        return oauthId;
    }

    @JsonProperty("oauth_id")
    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    @JsonProperty("oauth_token")
    public String getOauthToken() {
        return oauthToken;
    }

    @JsonProperty("oauth_token")
    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    @JsonProperty("oauth_city")
    public String getOauthCity() {
        return oauthCity;
    }

    @JsonProperty("oauth_city")
    public void setOauthCity(String oauthCity) {
        this.oauthCity = oauthCity;
    }

    @JsonProperty("oauth_birth_date")
    public String getOauthBirthDate() {
        return oauthBirthDate;
    }

    @JsonProperty("oauth_birth_date")
    public void setOauthBirthDate(String oauthBirthDate) {
        this.oauthBirthDate = oauthBirthDate;
    }

    @JsonProperty("os")
    public String getOs() {
        return os;
    }

    @JsonProperty("os")
    public void setOs(String os) {
        this.os = os;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("app_version")
    public String getAppVersion() {
        return appVersion;
    }

    @JsonProperty("app_version")
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
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
