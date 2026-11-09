# Dev Kubernetes deployment

This deployment runs one API replica on the `workload=app` node. It uses the
dev PostgreSQL instance at `10.40.1.71` and the shared, password-protected
Redis container on `rwbss-dev-plt01` (`10.40.1.225:6379`). The API is exposed
through a private NodePort:

- URL: `http://10.40.1.225:30180/bss-core-dmdm-service`
- Connect the laptop to the Client VPN before accessing it.

The database Secret (`bss-core-dmdm-db`), shared Redis Secret
(`bss-core-dmdm-redis`), and ECR pull Secret (`ecr-pull-secret`) are created
directly in Kubernetes and must not be committed. The Redis password is stored
in AWS Systems Manager Parameter Store as a `SecureString`; the Terraform
output gives the parameter ARN. Use an authorized AWS identity to retrieve it
with `aws ssm get-parameter --with-decryption`, then populate the Kubernetes
Secret. Other services can use the same host, port, and password.

The image tag identifies the source commit used for the deployment. The
deployment uses `IfNotPresent`, so it keeps using its cached image if the
short-lived ECR pull credential expires.

Apply the resources from the control plane with:

```sh
export KUBECONFIG=/etc/kubernetes/admin.conf
kubectl apply -k deploy/dev
```
