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

package com.globo.pepe.munin.data.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.util.Assert;

@Entity
public class Project {

    @Column(nullable = false, unique = true)
    private final String name;

    @Embedded
    private final Keystone keystone;

    @OneToMany(mappedBy = "project")
    private Set<Query> queries = new HashSet<>();

    public Project(String name, Keystone keystone) {
        Assert.hasText(name, "Name must not be null or empty!");
        Assert.notNull(keystone, "Keystone must not null!");

        this.name = name;
        this.keystone = keystone;
    }

    public String getName() {
        return name;
    }

    public Keystone getKeystone() {
        return keystone;
    }

    public Set<Query> getQueries() {
        return queries;
    }

    public Project setQueries(Set<Query> queries) {
        if (queries != null) {
            this.queries = queries;
        }
        return this;
    }
}
