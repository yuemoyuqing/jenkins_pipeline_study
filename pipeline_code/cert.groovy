pipeline {
    // no agent required to run here. All steps run in flyweight executor on Master
    agent any

    stages {
        stage("foo") {
            steps {
                echo "hello"
            }
        }

 stage(“cert”) {
            steps {

withCredentials([certificate(aliasVariable: 'valias', credentialsId: 'cert_1', keystoreVariable: 'vkeystore', passwordVariable: 'vpwd')]) {

        
       
        sh 'echo "keystore is $vkeystore"'

}

                echo "hello2"
            }
        }


    }
    

}

