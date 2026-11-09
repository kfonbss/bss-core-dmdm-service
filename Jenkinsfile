pipeline {
    agent {
        label 'rwbss-jen-ag01'
    }

    triggers {
        pollSCM('H/5 * * * *')
    }

    options {
        skipDefaultCheckout(true)
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '20'))
        timestamps()
    }

    environment {
        HARBOR_REGISTRY = '10.40.2.107:80'
        HARBOR_PROJECT = 'library'
        IMAGE_NAME = 'bss-core-dmdm-service'
        HARBOR_DEV_IMAGE = '10.40.2.107:80/library/bss-core-dmdm-service:dev'
        K8S_NAMESPACE = 'bss-core-dmdm-dev'
        K8S_DEPLOYMENT = 'bss-core-dmdm-service'
        K8S_CONTAINER = 'app'
        K8S_NODEPORT_URL = 'http://10.40.1.225:30180/bss-core-dmdm-service/actuator/health'
        DOCKER_BUILDKIT = '1'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                script {
                    env.IMAGE_TAG = sh(
                        script: 'git rev-parse --short=12 HEAD',
                        returnStdout: true
                    ).trim()
                    env.IMAGE = "${env.HARBOR_REGISTRY}/${env.HARBOR_PROJECT}/${env.IMAGE_NAME}:${env.IMAGE_TAG}"
                }
            }
        }

        stage('Build and publish') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'harbor-credentials',
                    usernameVariable: 'HARBOR_USERNAME',
                    passwordVariable: 'HARBOR_PASSWORD'
                )]) {
                    script {
                        try {
                            sh '''
                                set -eu
                                printf '%s' "$HARBOR_PASSWORD" |
                                    docker login "$HARBOR_REGISTRY" \
                                        --username "$HARBOR_USERNAME" \
                                        --password-stdin
                                docker build --pull \
                                    --tag "$IMAGE" \
                                    --tag "$HARBOR_DEV_IMAGE" .
                                docker push "$IMAGE"
                                docker push "$HARBOR_DEV_IMAGE"
                            '''
                        } finally {
                            sh 'docker logout "$HARBOR_REGISTRY" || true'
                        }
                    }
                }
            }
        }

        stage('Deploy to dev') {
            steps {
                withCredentials([file(
                    credentialsId: 'dev-kubeconfig',
                    variable: 'KUBECONFIG'
                )]) {
                    sh '''
                        set -eu
                        kubectl --kubeconfig="$KUBECONFIG" \
                            -n "$K8S_NAMESPACE" \
                            set image "deployment/$K8S_DEPLOYMENT" \
                            "$K8S_CONTAINER=$IMAGE"
                        kubectl --kubeconfig="$KUBECONFIG" \
                            -n "$K8S_NAMESPACE" \
                            rollout status "deployment/$K8S_DEPLOYMENT" \
                            --timeout=5m
                        curl --fail --silent --show-error \
                            --retry 12 --retry-delay 5 --retry-connrefused \
                            "$K8S_NODEPORT_URL"
                    '''
                }
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}
