pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage ("Build Maven"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rajaranjan/thor']])
            }
        }
        stage ('Build Docker Image'){
            steps{
                script{
                    bat 'docker build -t rajaranjans/thor .'
                }
            }
        }
        stage ('push image to Hub') {
            steps {
                script{
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'pass', usernameVariable: 'user')]) {
                        // bat 'docker login -u ${user} -p ${pass}'
                        // some block
                        bat 'docker push rajaranjans/thor'
                    }
                }
            }
        }
    }
}