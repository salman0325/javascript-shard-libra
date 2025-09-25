def call(String projectName, String imageTag, String dockerHubUser, String credentialsId) {
    withCredentials([usernamePassword(
        credentialsId: credentialsId,
        passwordVariable: 'DOCKER_PASS',
        usernameVariable: 'DOCKER_USER'
    )]) {
        sh """
            echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
            docker push ${dockerHubUser}/${projectName}:${imageTag}
        """
    }
}
