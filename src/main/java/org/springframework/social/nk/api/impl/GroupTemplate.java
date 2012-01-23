package org.springframework.social.nk.api.impl;

import org.springframework.social.nk.api.GroupOperations;
import org.springframework.web.client.RestTemplate;

public class GroupTemplate extends AbstractNkTemplate<GroupTemplate> implements GroupOperations<GroupTemplate> {
    
    public GroupTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

}