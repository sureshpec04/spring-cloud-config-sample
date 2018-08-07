# spring-cloud-config-sample

This sample provides how to manage the config values using Spring cloud config server/client.

Prerequisites:
1. Install JCE policy files in JVM. This is not enabled by default. Download the JCE policy files for Java version. I am using Java 8 and JCE can be downloaded from here: http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

2. Extract the zip and place the jar files (local_policy.jar, US_export_policy.jar) in this location: C:\Java\jdk1.8.0_181\jre\lib\security.

3. For asymmetric encryption, we need to generate the .jks file. Below is the command to generate .jks file using jdk keytool utility:

keytool -genkeypair -alias testconfigkey  -keyalg RSA -dname "CN=Web Server,OU=Unit,O=Organization,L=Chicago,S=IL,C=US" -keypass springcloudconfig -keystore server.jks -storepass springcloudconfig  -validity 365

4. Once the file is generated, place it in config server classpath or some location: (C:\keystore\server.jks)

5. Create a config.properties file that you want to manage from config client. It can be hosted in file location or git or github. 
Example 1: Accessing the config.properties natively

C:\config-repo\config.properties with below contents:
message=Spring Boot config_V2
password={cipher}AQAaThMIL+uJyH2JJE9b7wYfVIunDscrUE5gSFZX6iNz0m5JWu0lRZhYfO0U8VWApi7xu+gBfZW6szY59gcxv5ot8Pc0qiMS0mL3Kt99hFd7yJmY+M9J10cv6g4psbn7CsrJVZgC0Q+4LU9EuoGSYbw2pPpypwuTJ+6H41D7pHvU50waHwksXbx66H2HYTKdrBh0py0rpYqjm2DhgiJmuVlNcL5htKj39NpFN8X3ASFmuSTBBsNv4ifmBo8TchxoE9C9Zmw7MWnOplP4cDSjsz0KQWiuNmDkHLKMGaMY5WVqetCbpGAb2dv4pwKtVED6rsj9iIlGvHhTLUD/Kw75LdpYHKuvRRgO4/pIpY3/a8Dlghqbl8z2kQqfDrxq/IZARto=

Steps to Run the application:

1. Config Server: mvn springboot:run
2. Config Client: mvn springboot:run

3. To encrypt a property use this endpoint: (POST) http://localhost:8888/encrypt
Request body should contain the text you want to encrypt.

4. To decrypt a property use this endpoint: (POST) http://localhost:8888/decrypt
Request body should contain the encrypted/cipher text you want to decrypt.






