pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32"
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/jommi123/FarToCel.git'
            }
        }
    }
}