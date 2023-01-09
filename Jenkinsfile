pipeline {
  agent any
  tools {
    maven 'maven 3.8.7'
  }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/jovanaivanovska11/kiii-project']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t jovanaivanovska11/kiii-project .'
                }
            }
        }
        stage("Push image"){
            steps {
                withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u jovanaivanovska11 -p ${dockerhubpwd}'
                }
                sh 'docker push jovanaivanovska11/kiii-project'
            }
        }
    }
}