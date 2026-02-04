package com.pucetec.auth.controllers

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.authorization.AuthorityAuthorizationManager.hasRole
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
open class DummyController {
    @GetMapping("/public")
    open fun public(): Response {
        return Response("Todo ok. Público")
    }

    @GetMapping("/restricted")
    open fun restricted(): Response {
        return Response("Todo ok. Restringido")
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/restricted/admin")
    open fun admin(): Response {
        return Response("Todo ok. Admins")
    }

    @PreAuthorize("hasAnyRole('ROLE_admin','ROLE_Manager')")
    @GetMapping("/manager-area")
    open fun managerArea(): Response {
        return Response("Acceso permitido para Admin y Manager")
    }
}

data class Response(val message: String)