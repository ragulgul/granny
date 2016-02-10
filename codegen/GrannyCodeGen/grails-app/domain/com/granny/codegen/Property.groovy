package com.granny.codegen

import com.granny.codegen.enums.PropertyCollectionType
import com.granny.codegen.enums.PropertyType

class Property {

    Concept belongsToConcept
    PropertyType propertyType
    String conceptQualifiedName
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


    static constraints = {
        minSize(nullable: true)
        maxSize(nullable: true)
        defaultValue(nullable: true)
        description(nullable: true)
        propertyCollectionType(nullable: true)
        searchable(nullable: true)
        conceptQualifiedName(nullable: true)
    }

}
