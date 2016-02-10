package com.granny.codegen

import com.granny.codegen.repo.Repository

class Concept {

    Repository repository
    Set<Concept> usesConcepts
    Concept extendsConcept
    Set<Property> properties
    String name
    String description

    static constraints = {
        extendsConcept(nullable: true)
        description(nullable: true)
    }

    static hasMany = [usesConcepts: Concept,properties:Property]
}
