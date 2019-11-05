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
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}