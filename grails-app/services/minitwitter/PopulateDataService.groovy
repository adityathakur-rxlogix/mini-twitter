package minitwitter

import grails.transaction.Transactional

@Transactional
class PopulateDataService {

    void populateDefaultRoles() {
        if (!Role.count) {
            new Role(authority: 'ROLE_USER').save(validate: false)
            new Role(authority: 'ROLE_ADMIN').save(validate: false)
        }
    }

    void populateAdminUser() {
        if (!User.countByEmailAndUsername('aditya.thakur@rxlogix.com', 'adityathakur')){
            User admin = new User(email: 'aditya.thakur@rxlogix.com', username: 'adityathakur', password: 'default').save(flush:true, validate:false)
            Role role = Role.findByAuthority('ROLE_ADMIN')
            if (role && admin) {
                new UserRole(user: admin, role: role).save(flush:true)
            }
        }
    }
}
