#!/bin/bash

echo "Initiating env variables"
export APP_NAME="SparkApp" 
export INPUT_SOURCE="kafka"
export MASTER_NAME="master[2]"
export OUTPUT_FORMAT="console"
export OUTPUT_MODE="update"
export KAFKA_BOOTSTRAP_SERVER="192.168.43.66:9092"
export KAFKA_TOPIC_NAME="topic007"
export DELTA_CHECKPOINT_PATH="/home/kaushik/abc"
export DELTA_FILE_PATH="/home/kaushik/Desktop/deltafile"
export DELTA_SAVE_MODE="append"
echo "Initiated env variables"
