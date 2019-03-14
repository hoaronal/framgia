LES CUSTOM ADMIN
================
docs install and deploy 
----------------
**Installation guideline when deploying on a brand new server**

**Database Configurations:**
1. Check database schema before releasing to see whether we need to complete anything before deploying (i.e. DDL modification, data backup, data migration, index creation, etc.) or not.
2. Check jdbc configuration in the respective `.yml` configuration file to ensure that the username, password, jdbc url are all right.
     ```
     For instance:
     Before deploying the API on Aws development environment, we have to ensure that
     the below important jdbc's information in the file application.yml should be:
     
     spring:
       datasource:
         url: jdbc:mysql://10.0.1.196:3306/lesson_admin?zeroDateTimeBehavior=convertToNull
         username: qonect
         password: 123456
     ```
**Run and deploy:**
1. Run and stop with docker
     ```
     execute that command to run:
        nohup ./deploy.sh > nohup.out &
     check run log:
        tail -f nohup.out
     stop command:
        docker-compose down
     ```
2. Run with maven
     ```
     execute command:
        nohup ./run.sh > nohup.out &
     stop command:
        ./stop.sh
     ```
