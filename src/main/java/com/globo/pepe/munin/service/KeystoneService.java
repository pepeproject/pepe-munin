package com.globo.pepe.munin.service;

import com.globo.pepe.common.services.JsonLoggerService;
import org.openstack4j.api.OSClient.OSClientV3;
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

    @Value("${pepe.keystone.identifier}")
    private String identifier;

    private final JsonLoggerService jsonLoggerService;

    public KeystoneService(JsonLoggerService jsonLoggerService) {
        this.jsonLoggerService = jsonLoggerService;
    }

    public OSClientV3 authenticate(){
        OSClientV3 os = null;
        try {
             os = OSFactory.builderV3().endpoint(keystoneEndPoint)
                .credentials(user, password,Identifier.byId(identifier)).authenticate();
        }catch (Exception e){
            jsonLoggerService.newLogger(getClass()).put("short_message", e.getMessage()).sendError();
        }
        return os;
    }

}
