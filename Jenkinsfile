pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32"
        GIT_CREDENTIALS = credentials('jommi123')
        }
    stages {
    stage('Checkout') {
        steps {
            git branch: 'master', credentialsId: 'jommi123', url: 'https://github.com/jommi123/FarToCel.git'
        }
    }
   }
   }
  