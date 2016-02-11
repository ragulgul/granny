package com.granny.codegen

import com.granny.codegen.enums.PropertyType
import com.granny.codegen.repo.Repository

class Concept {

    Repository repository
    transient Set<Concept> usesConcepts = new HashSet<Concept>()
    Concept extendsConcept
    Set<ConceptProperty> conceptProperties
    String name
    String description

    static constraints = {
        extendsConcept(nullable: true)
        description(nullable: true)
    }

    static mappedBy = [conceptProperties:'belongsToConcept']

    def onLoad = {
        log.debug("Fired after object is loaded from DB")
        loadUsedConcepts()
    }

    def loadUsedConcepts() {
        conceptProperties.each {
            if (it.propertyType == PropertyType.Complex) {
                this.usesConcepts.add(it.referencedConcept)
            }
        }
    }

    static hasMany = [usesConcepts: Concept, conceptProperties: ConceptProperty]
}
