package com.granny.codegen

import com.granny.codegen.enums.PropertyType
import com.granny.codegen.repo.Repository

class Concept {

    Repository repository
    transient Set<Concept> usesConcepts
    Concept extendsConcept
    Set<ConceptProperty> conceptProperties
    String name
    String description

    static constraints = {
        extendsConcept(nullable: true)
        description(nullable: true)
    }

    def loadUsedConcepts(){
        /*conceptProperties.each {
            if(it.propertyType == PropertyType.Complex){
                try {
                    def concept = this.class.getClassLoader().loadClass(it.conceptQualifiedName)
                    this.usesConcepts.add(concept)
                }catch(exp){
                    log.error("Could not load class : $it.conceptQualifiedName")
                }
            }
        }*/
    }

    static hasMany = [usesConcepts: Concept,conceptProperties:ConceptProperty]
}
