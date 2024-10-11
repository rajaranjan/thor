pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage ("Build Maven"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rajaranjan/thor']])
                bat 'mvn clean install'
            }
        }
        stage ('Build Docker Image'){
            steps{
                script{
                    bat 'docker build -t thor .'
                }
            }
        }
    }
}