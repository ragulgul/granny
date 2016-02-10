package com.granny.codegen.repo

class Repository {

    String name
    String description
    String uri
    String shorthand

    static constraints = {
        description(nullable: true)
        name(nullable: true)
        shorthand(nullable: true)
    }
}
