#!/bin/bash

javac -cp ./Server:./ClientInterface:. ./Server/*java
java Server.StorageSystem
