# FI.API Sign Tool

Sample Java program to demonstrate how to generate digital signature / sign payload.

This sample reads the private key from the file system for demonstration purposes. In the production environment, the private key should remain in FIPS 140-2 level 2 compliant Hardware Security Module (HSM) such as Azure KV HSM, Amazon CloudHSM, GoogleCloudHSM (this is not an exhaustive list) and only via the HSM the payload is signed.

This sample ClearBank® code is intended to provide Financial Institutions examples to help integrate with ClearBank®’s live API.
All information provided by ClearBank® is provided "as is" and without any implied warranty, representation, condition or otherwise, regarding its accuracy or completeness.

For further information please consult the [ClearBank® Developer Portal](https://clearbank.github.io/).
