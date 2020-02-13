pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'apache-maven') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'apache-maven') {
                    sh 'mvn test'
                }
            }
        }

	stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    // Optionally use a Maven environment you've configured already
                    withMaven(maven:'apache-maven') {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }


        /*stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'apache-maven') {
                    sh 'mvn deploy'
                }
            }
        }*/

        stage ('Clearing Stage') {
                    steps {
                        withMaven(maven : 'apache-maven') {
                            sh 'mvn clean'
                        }
                    }
                }


    }
}
