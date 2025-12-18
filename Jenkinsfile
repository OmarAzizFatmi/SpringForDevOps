pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/OmarAzizFatmi/SpringForDevOps'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
        sh 'mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN'
    }
}

            }
        }
    }
}
