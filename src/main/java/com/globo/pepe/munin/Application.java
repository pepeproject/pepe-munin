/*
 * Copyright (c) 2019. Globo.com - ATeam
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Authors: See AUTHORS file
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.globo.pepe.munin;

import com.globo.pepe.common.configuration.DatabaseConfiguration;
import com.globo.pepe.common.controller.HealthcheckController;
import com.globo.pepe.common.controller.InfoController;
import com.globo.pepe.common.services.JsonLoggerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Import({JsonLoggerService.class, HealthcheckController.class, InfoController.class, DatabaseConfiguration.class})
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
@EntityScan( basePackages = {"com.globo.pepe.common.model.munin"} )
@EnableJpaRepositories(basePackages = "com.globo.pepe.munin.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
