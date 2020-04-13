pipeline {
    agent any
  triggers{
upstream(upstreamProjects: 'pipeline1', threshold: hudson.model.Result.SUCCESS) 
}
    stages {
        stage('Example') {
            steps {
                echo 'Hello World'
            }
        }
    }
}