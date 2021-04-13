package com.up42.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.up42.task.api.FeatureResponse;
import com.up42.task.repositories.UP42DataModelRepository;
import com.up42.task.repositories.model.generated.UP42DataModel;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate testRestTemplate;

    @Autowired
    private UP42DataModelRepository repository;

    @Before
    public void init(){

        final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder().rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder, null, null, null);
    }

    @Test
    public void testFindFeatureByIdWithValidFeatureId(){

        String featureId = "0b598c52-7bf2-4df0-9d09-94229cdfbc0b";
        final Optional<UP42DataModel> feature = repository.findByFeatureId(featureId);

        final ResponseEntity<FeatureResponse> featureResponseResponseEntity = testRestTemplate.getForEntity("/features/{id}", FeatureResponse.class, featureId);
        final FeatureResponse body = featureResponseResponseEntity.getBody();

        assertEquals(200, featureResponseResponseEntity.getStatusCodeValue());
        assertNotNull(body);
        assertNotNull(body.getMissionName());
        assertTrue(feature.isPresent());
        assertEquals(feature.get().getFeatures().get(0).getProperties().getAcquisition().getMissionName(), body.getMissionName());
    }

    @Test
    public void testFindFeatureByIdWithInvalidFeatureId(){

        String featureId = "GGG0b598c52-7bf2-4df0-9d09-94229cdfbc0b";

        final ResponseEntity<FeatureResponse> featureResponseResponseEntity = testRestTemplate.getForEntity("/features/{id}", FeatureResponse.class, featureId);
        final FeatureResponse body = featureResponseResponseEntity.getBody();

        assertEquals(404, featureResponseResponseEntity.getStatusCodeValue());
    }
}
