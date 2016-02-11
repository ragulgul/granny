package com.granny.codegen

import com.granny.codegen.enums.PropertyCollectionType
import com.granny.codegen.enums.PropertyType

class ConceptProperty {

    Concept belongsToConcept
    PropertyType propertyType
    Concept referencedConcept
    String name
    String description = null
    Boolean multipleEntries = false
    PropertyCollectionType propertyCollectionType
    /**
     * Indexing properties
     */
    Boolean searchable = null
    /**
     * Contraints
     */
    Integer minSize
    Integer maxSize
    Boolean nullable = true
    String defaultValue
    Boolean unique = false


    static constraints = {
        minSize(nullable: true)
        maxSize(nullable: true)
        defaultValue(nullable: true)
        description(nullable: true)
        propertyCollectionType(nullable: true)
        searchable(nullable: true)
        referencedConcept(nullable: true)
    }

}
