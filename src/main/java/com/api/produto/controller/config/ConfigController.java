package com.api.produto.controller.config;

import com.api.produto.indicator.ApplicationAvailabilityIndicator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api/config")
@Api(value="Api Config")
public class ConfigController {

    @Autowired
    ApplicationAvailabilityIndicator applicationAvailabilityIndicator;

    @ApiOperation(value="Tempo para a aplicacao ficar DOWN")
    @PostMapping("/v1.0/unhealthfor/{time}")
    public void unHealth(@RequestBody int time) {
        applicationAvailabilityIndicator.unHealthFor(time);
    }

    @ApiOperation(value="Tempo para a aplicacao ficar DOWN")
    @PostMapping("/v1.0/unreadfor/{time}")
    public void unReadFor(@RequestBody int time) {
        applicationAvailabilityIndicator.unReadFor(time);
    }

}
