package in.zipgo.automation_framework.tests;

import in.zipgo.automation_framework.enums.SessionEnums;
import in.zipgo.automation_framework.managers.api.RestManager;
import in.zipgo.automation_framework.request.data.Session;
import in.zipgo.automation_framework.response.data.MemberResponse;
import in.zipgo.automation_framework.response.data.Route;
import in.zipgo.automation_framework.rest.modules.AuthContext;
import in.zipgo.automation_framework.rest.modules.Authentication;
import in.zipgo.automation_framework.rest.modules.BasicMediaTypes;
import in.zipgo.automation_framework.rest.modules.DefaultAuthentication;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests extends Assert {

    @Test
    public void sampleApiTests() {
        Authentication auth = new DefaultAuthentication(new AuthContext());
        RestManager manager = new RestManager(BasicMediaTypes.JSON, auth, null);

        Session session = SessionEnums.VALID_SESSION_INFO.getData();
        
        Response response = manager.post("https://beta.zipgo.in", "/sessions/connect", session);
        assertEquals(response.statusCode(), 200, "Something went wrong with the request");
        MemberResponse memResp = response.as(MemberResponse.class);
        String ssoToken = memResp.getSsoToken();

        List<Header> headerArr = new ArrayList<>();
        Header authHeader = new Header("Authorization", ssoToken);
        headerArr.add(authHeader);
        Headers headers = new Headers(headerArr);
        manager = new RestManager(BasicMediaTypes.JSON, auth, headers);
        response = manager.get("https://beta.zipgo.in", "/route_trips");
        assertEquals(response.statusCode(), 200, "Something went wrong with the request");
        List<Route> routes = response.as(List.class);
        assertTrue(routes.size() > 10, "Not enough routes created");
    }
}
