package minitwitter

import grails.transaction.Transactional
import minitwitter.constants.RoleConstants

@Transactional
class PopulateDataService {



    void populateDefaultRoles() {
        if (!Role.count) {
            new Role(authority: RoleConstants.ROLE_USER).save(validate: false)
            new Role(authority: RoleConstants.ROLE_ADMIN).save(validate: false)
        }
    }

    void populateAdminUserAndWelcomeTweet() {
        if (!User.countByEmailAndUsername('aditya.thakur@rxlogix.com', 'adityathakur')){
            User admin = new User(fullName: 'Aditya Thakur', email: 'aditya.thakur@rxlogix.com', username: 'aditya', password: 'default').save(flush:true, validate:false)
            Role role = Role.findByAuthority(RoleConstants.ROLE_ADMIN)
            if (role && admin) {
                new UserRole(user: admin, role: role).save(flush:true)
                populateWelcomeTweet(admin);
            }
        }
    }

    void populateWelcomeTweet(User user) {
        new Tweet(text: 'Welcome to Twitter!', createdBy: user).save(flush:true)
    }

}
