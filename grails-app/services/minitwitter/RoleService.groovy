package minitwitter

import grails.transaction.Transactional

@Transactional
class RoleService {

    Role findRoleByAuthority(String authority) {
        return authority ? Role.findByAuthority(authority): null
    }
}
