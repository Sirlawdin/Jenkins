def buildJar() {
    echo "building the application..."
    sh 'mvn package'
}
def buildImage() {
    echo "building the doker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]){ sh 'docker build -t sirlawdin/my-devops-repo:jma-2.0 .' 
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push sirlawdin/my-devops-repo:jma-2.0'
}

def testApp() {
    echo 'testing the application...'
}

def deployApp() {
    echo 'deploying the application...'
    echo "deploying version ${params.VERSION}"
}


return this 
