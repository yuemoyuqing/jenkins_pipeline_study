pipeline {
    agent any
    environment {
               AWS_SECRET_ACCESS_KEY = credentials('user1')
    }
    stages {
        stage('Example stage 1') {
            steps {
               sh 'echo "password is $AWS_SECRET_ACCESS_KEY "'
            }
        }
    }
}