pipeline {
    agent any
    tools {
        maven 'maven-3.8.4'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the doker image..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                       sh 'docker build -t sirlawdin/my-devops-repo:jma-2.0 .' 
                       sh 'echo $PASS | docker login -u $USER --password-stdin' 
                       sh 'docker push sirlawdin/my-devops-repo:jma-2.0'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying the application..."
                }
            }
        }
    }
}
