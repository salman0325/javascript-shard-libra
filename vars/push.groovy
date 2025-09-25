ddef call(String projectName, String imageTag, String dockerHubUser, String credentialsId) {
    withCredentials([usernamePassword(credentialsId: docker-hub-credi, passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
        sh """
            docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
            docker push ${dockerHubUser}/{projectName}:{imageTag}
        """
    }
}
