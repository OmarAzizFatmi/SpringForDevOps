pipeline {
    agent any

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/OmarAzizFatmi/SpringForDevOps'
            }
        }

        stage('Build') {
            steps {
                sh 'echo "Build launched from Jenkinsfile"'
            }
        }
    }
}

