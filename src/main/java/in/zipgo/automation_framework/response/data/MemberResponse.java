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
    "email",
    "phone",
    "city",
    "country",
    "invite_code",
    "total_invitee",
    "referrer_code",
    "search_keywords",
    "preferred_city",
    "image",
    "company_name",
    "home_location",
    "home_latitude",
    "home_longitude",
    "work_location",
    "work_latitude",
    "work_longitude",
    "reach_work_by",
    "leave_work_by",
    "dob",
    "gender",
    "created_at",
    "device_login_breached",
    "server_based_suggestions",
    "two_column",
    "multi_currency_wallets",
    "multi_currency_customer_moneys",
    "referrer",
    "multi_currency_balances",
    "membership",
    "sso_token",
    "last_working_day",
    "has_orders",
    "assistance_phone",
    "mandatory_customer_fields",
    "holiday"
})
public class MemberResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("invite_code")
    private String inviteCode;
    @JsonProperty("total_invitee")
    private Integer totalInvitee;
    @JsonProperty("referrer_code")
    private Object referrerCode;
    @JsonProperty("search_keywords")
    private List<String> searchKeywords = null;
    @JsonProperty("preferred_city")
    private String preferredCity;
    @JsonProperty("image")
    private Object image;
    @JsonProperty("company_name")
    private Object companyName;
    @JsonProperty("home_location")
    private Object homeLocation;
    @JsonProperty("home_latitude")
    private Object homeLatitude;
    @JsonProperty("home_longitude")
    private Object homeLongitude;
    @JsonProperty("work_location")
    private Object workLocation;
    @JsonProperty("work_latitude")
    private Object workLatitude;
    @JsonProperty("work_longitude")
    private Object workLongitude;
    @JsonProperty("reach_work_by")
    private Object reachWorkBy;
    @JsonProperty("leave_work_by")
    private Object leaveWorkBy;
    @JsonProperty("dob")
    private Object dob;
    @JsonProperty("gender")
    private Object gender;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("device_login_breached")
    private Boolean deviceLoginBreached;
    @JsonProperty("server_based_suggestions")
    private Boolean serverBasedSuggestions;
    @JsonProperty("two_column")
    private Boolean twoColumn;
    @JsonProperty("multi_currency_wallets")
    private List<MultiCurrencyWallet> multiCurrencyWallets = null;
    @JsonProperty("multi_currency_customer_moneys")
    private List<Object> multiCurrencyCustomerMoneys = null;
    @JsonProperty("referrer")
    private Object referrer;
    @JsonProperty("multi_currency_balances")
    private List<MultiCurrencyBalance> multiCurrencyBalances = null;
    @JsonProperty("membership")
    private Object membership;
    @JsonProperty("sso_token")
    private String ssoToken;
    @JsonProperty("last_working_day")
    private String lastWorkingDay;
    @JsonProperty("has_orders")
    private Boolean hasOrders;
    @JsonProperty("assistance_phone")
    private Object assistancePhone;
    @JsonProperty("mandatory_customer_fields")
    private List<Object> mandatoryCustomerFields = null;
    @JsonProperty("holiday")
    private Holiday holiday;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
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

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("invite_code")
    public String getInviteCode() {
        return inviteCode;
    }

    @JsonProperty("invite_code")
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    @JsonProperty("total_invitee")
    public Integer getTotalInvitee() {
        return totalInvitee;
    }

    @JsonProperty("total_invitee")
    public void setTotalInvitee(Integer totalInvitee) {
        this.totalInvitee = totalInvitee;
    }

    @JsonProperty("referrer_code")
    public Object getReferrerCode() {
        return referrerCode;
    }

    @JsonProperty("referrer_code")
    public void setReferrerCode(Object referrerCode) {
        this.referrerCode = referrerCode;
    }

    @JsonProperty("search_keywords")
    public List<String> getSearchKeywords() {
        return searchKeywords;
    }

    @JsonProperty("search_keywords")
    public void setSearchKeywords(List<String> searchKeywords) {
        this.searchKeywords = searchKeywords;
    }

    @JsonProperty("preferred_city")
    public String getPreferredCity() {
        return preferredCity;
    }

    @JsonProperty("preferred_city")
    public void setPreferredCity(String preferredCity) {
        this.preferredCity = preferredCity;
    }

    @JsonProperty("image")
    public Object getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Object image) {
        this.image = image;
    }

    @JsonProperty("company_name")
    public Object getCompanyName() {
        return companyName;
    }

    @JsonProperty("company_name")
    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("home_location")
    public Object getHomeLocation() {
        return homeLocation;
    }

    @JsonProperty("home_location")
    public void setHomeLocation(Object homeLocation) {
        this.homeLocation = homeLocation;
    }

    @JsonProperty("home_latitude")
    public Object getHomeLatitude() {
        return homeLatitude;
    }

    @JsonProperty("home_latitude")
    public void setHomeLatitude(Object homeLatitude) {
        this.homeLatitude = homeLatitude;
    }

    @JsonProperty("home_longitude")
    public Object getHomeLongitude() {
        return homeLongitude;
    }

    @JsonProperty("home_longitude")
    public void setHomeLongitude(Object homeLongitude) {
        this.homeLongitude = homeLongitude;
    }

    @JsonProperty("work_location")
    public Object getWorkLocation() {
        return workLocation;
    }

    @JsonProperty("work_location")
    public void setWorkLocation(Object workLocation) {
        this.workLocation = workLocation;
    }

    @JsonProperty("work_latitude")
    public Object getWorkLatitude() {
        return workLatitude;
    }

    @JsonProperty("work_latitude")
    public void setWorkLatitude(Object workLatitude) {
        this.workLatitude = workLatitude;
    }

    @JsonProperty("work_longitude")
    public Object getWorkLongitude() {
        return workLongitude;
    }

    @JsonProperty("work_longitude")
    public void setWorkLongitude(Object workLongitude) {
        this.workLongitude = workLongitude;
    }

    @JsonProperty("reach_work_by")
    public Object getReachWorkBy() {
        return reachWorkBy;
    }

    @JsonProperty("reach_work_by")
    public void setReachWorkBy(Object reachWorkBy) {
        this.reachWorkBy = reachWorkBy;
    }

    @JsonProperty("leave_work_by")
    public Object getLeaveWorkBy() {
        return leaveWorkBy;
    }

    @JsonProperty("leave_work_by")
    public void setLeaveWorkBy(Object leaveWorkBy) {
        this.leaveWorkBy = leaveWorkBy;
    }

    @JsonProperty("dob")
    public Object getDob() {
        return dob;
    }

    @JsonProperty("dob")
    public void setDob(Object dob) {
        this.dob = dob;
    }

    @JsonProperty("gender")
    public Object getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Object gender) {
        this.gender = gender;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("device_login_breached")
    public Boolean getDeviceLoginBreached() {
        return deviceLoginBreached;
    }

    @JsonProperty("device_login_breached")
    public void setDeviceLoginBreached(Boolean deviceLoginBreached) {
        this.deviceLoginBreached = deviceLoginBreached;
    }

    @JsonProperty("server_based_suggestions")
    public Boolean getServerBasedSuggestions() {
        return serverBasedSuggestions;
    }

    @JsonProperty("server_based_suggestions")
    public void setServerBasedSuggestions(Boolean serverBasedSuggestions) {
        this.serverBasedSuggestions = serverBasedSuggestions;
    }

    @JsonProperty("two_column")
    public Boolean getTwoColumn() {
        return twoColumn;
    }

    @JsonProperty("two_column")
    public void setTwoColumn(Boolean twoColumn) {
        this.twoColumn = twoColumn;
    }

    @JsonProperty("multi_currency_wallets")
    public List<MultiCurrencyWallet> getMultiCurrencyWallets() {
        return multiCurrencyWallets;
    }

    @JsonProperty("multi_currency_wallets")
    public void setMultiCurrencyWallets(List<MultiCurrencyWallet> multiCurrencyWallets) {
        this.multiCurrencyWallets = multiCurrencyWallets;
    }

    @JsonProperty("multi_currency_customer_moneys")
    public List<Object> getMultiCurrencyCustomerMoneys() {
        return multiCurrencyCustomerMoneys;
    }

    @JsonProperty("multi_currency_customer_moneys")
    public void setMultiCurrencyCustomerMoneys(List<Object> multiCurrencyCustomerMoneys) {
        this.multiCurrencyCustomerMoneys = multiCurrencyCustomerMoneys;
    }

    @JsonProperty("referrer")
    public Object getReferrer() {
        return referrer;
    }

    @JsonProperty("referrer")
    public void setReferrer(Object referrer) {
        this.referrer = referrer;
    }

    @JsonProperty("multi_currency_balances")
    public List<MultiCurrencyBalance> getMultiCurrencyBalances() {
        return multiCurrencyBalances;
    }

    @JsonProperty("multi_currency_balances")
    public void setMultiCurrencyBalances(List<MultiCurrencyBalance> multiCurrencyBalances) {
        this.multiCurrencyBalances = multiCurrencyBalances;
    }

    @JsonProperty("membership")
    public Object getMembership() {
        return membership;
    }

    @JsonProperty("membership")
    public void setMembership(Object membership) {
        this.membership = membership;
    }

    @JsonProperty("sso_token")
    public String getSsoToken() {
        return ssoToken;
    }

    @JsonProperty("sso_token")
    public void setSsoToken(String ssoToken) {
        this.ssoToken = ssoToken;
    }

    @JsonProperty("last_working_day")
    public String getLastWorkingDay() {
        return lastWorkingDay;
    }

    @JsonProperty("last_working_day")
    public void setLastWorkingDay(String lastWorkingDay) {
        this.lastWorkingDay = lastWorkingDay;
    }

    @JsonProperty("has_orders")
    public Boolean getHasOrders() {
        return hasOrders;
    }

    @JsonProperty("has_orders")
    public void setHasOrders(Boolean hasOrders) {
        this.hasOrders = hasOrders;
    }

    @JsonProperty("assistance_phone")
    public Object getAssistancePhone() {
        return assistancePhone;
    }

    @JsonProperty("assistance_phone")
    public void setAssistancePhone(Object assistancePhone) {
        this.assistancePhone = assistancePhone;
    }

    @JsonProperty("mandatory_customer_fields")
    public List<Object> getMandatoryCustomerFields() {
        return mandatoryCustomerFields;
    }

    @JsonProperty("mandatory_customer_fields")
    public void setMandatoryCustomerFields(List<Object> mandatoryCustomerFields) {
        this.mandatoryCustomerFields = mandatoryCustomerFields;
    }

    @JsonProperty("holiday")
    public Holiday getHoliday() {
        return holiday;
    }

    @JsonProperty("holiday")
    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
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
