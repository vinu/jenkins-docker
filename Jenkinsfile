pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                script {

                    docker.withRegistry('https://docker.pkg.github.com', 'github-docker-push') {
                            def customImage = docker.build("vinu/jenkins-docker/my-image:${env.BUILD_ID}")
                            /* Push the container to the custom Registry */
                            customImage.push()
                        }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'

                script {

                 withCredentials([sshUserPrivateKey(credentialsId: 'azure_staging_appdeployer', keyFileVariable: 'sshKey', passphraseVariable: '', usernameVariable: 'sshUser')]) {
                                             def remote = [:]
                                             remote.name = 'azure_staging'
                                             remote.host = '52.247.236.99'
                                             remote.user = sshUser
                                             remote.identityFile = sshKey
                                             remote.allowAnyHosts = true
                                             sshCommand remote: remote, command: "nohup /home/appdeployer/slack-integration/deploy.sh  ${env.BUILD_ID} 2>&1"
                                         }
                 }


            }
        }
    }
}