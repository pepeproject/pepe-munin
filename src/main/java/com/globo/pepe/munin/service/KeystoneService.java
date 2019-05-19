package com.globo.pepe.munin.service;

import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.api.exceptions.AuthenticationException;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.openstack.OSFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeystoneService {

    @Value("${pepe.keystone.url}")
    private String keystoneEndPoint;

    @Value("${pepe.keystone.user}")
    private String user;

    @Value("${pepe.keystone.password}")
    private String password;

    @Value("${pepe.keystone.domain}")
    private String domain;

    @Value("${pepe.keystone.project}")
    private String project;

    public OSClientV3 authenticate() throws Exception {
        OSClientV3 client = OSFactory.builderV3()
                .endpoint(keystoneEndPoint)
                .credentials(user, password, null)
                .scopeToProject(Identifier.byName(project), Identifier.byId(domain))
                .authenticate();
        if (client == null) {
            throw new AuthenticationException("client is null", 401);
        }
        return client;
    }

}
