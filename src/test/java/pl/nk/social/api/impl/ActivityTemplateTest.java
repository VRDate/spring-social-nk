package pl.nk.social.api.impl;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import pl.nk.social.api.ActivityOperations;
import pl.nk.social.api.impl.ActivityTemplate;

/**
 */
public class ActivityTemplateTest extends AbstractTemplateTest {

    /**
     * Field oper.
     */
    private ActivityOperations<ActivityTemplate> oper;

    /**
     * Method setup.
     */
    @Before
    public void setup() {
        super.setup();
        this.oper = this.nk.activityOperations();
    }

    /**
     * Method addActivityForAll.
     */
    @Test
    public void addActivityForAll() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        this.mockServer.expect(requestTo(oper.getSocialResourceUrl() + "/activities/@me/@all/app.sledzik")).andExpect(method(POST))
                .andRespond(withResponse("{\"entry\":{}}", responseHeaders));

        this.oper.addActivityForAll("some title");
    }

    /**
     * Method addActivityForFriends.
     */
    @Test
    public void addActivityForFriends() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        this.mockServer
                .expect(requestTo(oper.getSocialResourceUrl() + "/activities/@me/@friends/app.sledzik"))
                .andExpect(method(POST)).andRespond(withResponse("{\"entry\":{}}", responseHeaders));

        this.oper.addActivityForFriends("some title");
    }

}
